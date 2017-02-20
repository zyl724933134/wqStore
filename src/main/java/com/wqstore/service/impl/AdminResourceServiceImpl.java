package com.wqstore.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.wqstore.dao.AdminResourceMapper;
import com.wqstore.domain.AdminResource;
import com.wqstore.domain.AdminResourceExample;
import com.wqstore.domain.AdminResourceExample.Criteria;
import com.wqstore.result.CollectionContentUtils;
import com.wqstore.result.DateUtil;
import com.wqstore.result.RequestResultVo;
import com.wqstore.service.AdminResourceService;

@Service("resourceService")
public class AdminResourceServiceImpl implements AdminResourceService {
	private static final Logger logger = LoggerFactory.getLogger(AdminResourceServiceImpl.class);
	
	@Resource
	private AdminResourceMapper resourceMapper;
	
	public List<AdminResource> getResourceTree() {
		List<AdminResource> list = null;
		try {
			AdminResourceExample example = new AdminResourceExample();
			example.setOrderByClause("weight asc");
			list = resourceMapper.selectByExample(example);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("getResourceTree error ",e);
		}
		
		List<AdminResource> tree = this.toTree(list);
		this.sort(tree);
		return tree;
	}

	/**
	 * 将list转换成树形结构
	 * @param list
	 * @return
	 */
	private List<AdminResource> toTree(List<AdminResource> list) {
		List<AdminResource> tree = new ArrayList<AdminResource>();
		if(list==null) {
			return null;
		}
		AdminResource node = null;
		AdminResource parentNode = null;
		Map<String, AdminResource> treeMap = new HashMap<String, AdminResource>();
		for (AdminResource resource : list) {
			treeMap.put(resource.getCode(), resource);
		}
		List<AdminResource> children = null; 
		for (Map.Entry<String, AdminResource> entry : treeMap.entrySet()) {
			node = entry.getValue();
			if(node == null ) {
				continue;
			}
			parentNode = treeMap.get(node.getParentCode());
			if(parentNode == null){
				tree.add(node);
			}else {
				children = parentNode.getChildren();
				if(children == null) {
					children = new ArrayList<AdminResource>();
					children.add(node);
					parentNode.setChildren(children);
				}else {
					children.add(node);
				}
			}
		}
		return tree;
	}

	@Override
	@Transactional
	public RequestResultVo<AdminResource> updateResource(AdminResource resource) {
		RequestResultVo<AdminResource> result = new RequestResultVo<AdminResource>();
		if(resource == null || resource.getId() == null) {
			result.setSuccess(false);
			result.setErrorMessage("资源信息或资源ID不能为空！");
			return result;
		}
		resource.setModifiedTime(DateUtil.getChineseTime());
		AdminResource exists = resourceMapper.selectByPrimaryKey(resource.getId());
		AdminResourceExample example = new AdminResourceExample();
		AdminResourceExample.Criteria criteria = example.createCriteria();
		criteria.andCodeEqualTo(resource.getCode());
		criteria.andCodeNotEqualTo(exists.getCode());
		List<AdminResource> list = resourceMapper.selectByExample(example);
		if(CollectionUtils.isEmpty(list)) {
			String parentCode = StringUtils.isBlank(resource.getParentCode())?null:resource.getParentCode();
			//String url = convertUrl(resource.getUrl());
			resource.setParentCode(parentCode);
			//resource.setUrl(url);
			//更新子节点
			if(!StringUtils.equals(parentCode, exists.getParentCode())) {
				updateChildrenCode(exists.getParentCode(),exists.getCode());
			}
			int count = resourceMapper.updateByPrimaryKey(resource);
			if(count <=0 ){
				result.setSuccess(false);
				result.setErrorMessage("资源信息更新失败！");
			}
		}else {
			result.setSuccess(false);
			result.setErrorMessage("资源编码已存在！");
		}
		return result;
	}

	@Override
	@Transactional
	public RequestResultVo<AdminResource> insertResource(AdminResource resource) {
		RequestResultVo<AdminResource> result = new RequestResultVo<AdminResource>();
		List<AdminResource> list = null;
		if(resource == null ) {
			result.setSuccess(false);
			result.setErrorMessage("资源信息不能为空！");
			return result;
		}
		resource.setCreateTime(DateUtil.getChineseTime());
		AdminResourceExample example = new AdminResourceExample();
		AdminResourceExample.Criteria criteria = example.createCriteria();
		criteria.andCodeEqualTo(resource.getCode());
		list = resourceMapper.selectByExample(example);
		if(CollectionUtils.isEmpty(list)) {
			String parentCode = StringUtils.isBlank(resource.getParentCode())?null:resource.getParentCode();
			//String url = convertUrl(resource.getUrl());
			resource.setParentCode(parentCode);
			//resource.setUrl(url);
			int count = resourceMapper.insert(resource);
			if(count <= 0) {
				result.setSuccess(false);
				result.setErrorMessage("资源添加失败！");
			}
		}else{
			result.setSuccess(false);
			result.setErrorMessage("该资源编码已存在！");
		}
		
		return result;
	}
	
	/**
	 * 转换URL地址
	 * @param url
	 * @return
	 */
//	private String convertUrl(String url) {
//		if(StringUtils.isNotBlank(url)) {
//			if(!url.startsWith("/")) {
//				url = "/" + url;
//			}
//			if(!url.endsWith(".action")) {
//				url+=".action";
//			}
//			return url;
//		}
//		return null;
//	}

	@Override
	@Transactional
	public RequestResultVo<AdminResource> deleteResource(Long id) {
		RequestResultVo<AdminResource> result = new RequestResultVo<AdminResource>();
		if(id == null) {
			result.setSuccess(false);
			result.setErrorMessage("资源编码不能为空！");
			return result;
		}
		AdminResource res = resourceMapper.selectByPrimaryKey(id);
		if(res != null) {
			updateChildrenCode(res.getParentCode(), res.getCode());
		}
		int count = resourceMapper.deleteByPrimaryKey(id);
		if(count <= 0) {
			result.setSuccess(false);
			result.setErrorMessage("该资源删除失败！");
		}
		
		return result;
	}

	@Override
	public AdminResource findResourceById(Long id) {
		List<String> list = null;
		AdminResource resource = null;
		try {
			list = resourceMapper.findExcResourceCodeById(id);
			resource = resourceMapper.selectByPrimaryKey(id);
		} catch (Exception e) {
			logger.error("findResourceById error",e);
		}
		if(!CollectionUtils.isEmpty(list) && resource != null) {
			list.remove(resource.getParentCode());
			list.add(0, resource.getParentCode());
			resource.setParentCode(StringUtils.join(list, ","));
		}
		return resource;
	}
	
	/**
	 * 将目标节点的父节点，赋值给所有的子节点
	 * @param parentCode
	 * @param code
	 */
	@Transactional
	private void updateChildrenCode(String parentCode, String code) {
		
		if(parentCode != null && code != null) {
			AdminResource resource = new AdminResource();
			resource.setParentCode(parentCode);
			
			AdminResourceExample pExample = new AdminResourceExample();
			AdminResourceExample.Criteria pCriteria = pExample.createCriteria();
			pCriteria.andParentCodeEqualTo(code);
			resourceMapper.updateByExampleSelective(resource, pExample);
		}
	}

	@Override
	public List<AdminResource> getResourceTreeByRoleId(Long id) {
		List<AdminResource> list = null;
		try {
			list = resourceMapper.findResourceByRoleId(id);
		} catch (Exception e) {
			logger.error("getResourceTreeByRoleId error",e);
		}
		
		List<AdminResource> tree = this.toTree(list);
		this.sort(tree);
		return tree;
	}

	@Override
	public List<AdminResource> getResourceTreeByNonRoleId(Long id) {
		List<AdminResource> list = null;
		try {
			list =resourceMapper.findResourceByNonRoleId(id);
		} catch (Exception e) {
			logger.error("getResourceTreeByNonRoleId error",e);
		}
		List<AdminResource> tree = this.toTree(list);
		this.sort(tree);
		return tree;
	}

	@Override
	@Transactional
	public RequestResultVo<AdminResource> addRoleResource(List<Long> resourceIds, Long roleId) {
		RequestResultVo<AdminResource> result = new RequestResultVo<AdminResource>();
		Map<String, Object> map = new HashMap<String, Object>();
		if(CollectionUtils.isEmpty(resourceIds) || roleId == null) {
			result.setSuccess(false);
			result.setErrorMessage("角色id或资源id不能为空！");
			return result;
		}
		map.put("resourceIds", resourceIds);
		map.put("roleId", roleId);
		int count = resourceMapper.addRoleResourceRelation(map);
		if(count <= 0) {
			result.setSuccess(false);
			result.setErrorMessage("角色添加资源失败！");
		}
		return result;
	}

	@Override
	@Transactional
	public RequestResultVo<AdminResource> deleteRoleResource(List<Long> resourceIds,	Long roleId) {
		RequestResultVo<AdminResource> result = new RequestResultVo<AdminResource>();
		Map<String, Object> map = new HashMap<String, Object>();
		if(CollectionUtils.isEmpty(resourceIds) || roleId == null) {
			result.setSuccess(false);
			result.setErrorMessage("角色id或资源id不能为空！");
			return result;
		}
		map.put("resourceIds", resourceIds);
		map.put("roleId", roleId);
		int count = resourceMapper.deleteRoleResourceRelation(map);
		if(count <= 0) {
			result.setSuccess(false);
			result.setErrorMessage("角色添加资源失败！");
		}
		return result;
	}
	
	/**
	 * 递归深度排序
	 * @param list
	 */
	private void sort(List<AdminResource> list) {
		CollectionContentUtils.sortList(list, "weight", CollectionContentUtils.SORT_ASC);
		for (AdminResource resource : list) {
			List<AdminResource> children = resource.getChildren();
			if(!CollectionUtils.isEmpty(children)) {
				this.sort(children);
			}
		}
	}

	@Override
	public List<AdminResource> findResourceByRoleIds(List<Long> roleIds) {
		List<AdminResource> list = new ArrayList<AdminResource>();
		if(CollectionUtils.isEmpty(roleIds)) {
			return list;
		}
		try {
			list = resourceMapper.findResourceByRoleIds(roleIds);
		} catch (Exception e) {
			logger.error("findResourceByRoleIds error",e);
		}
		return list;
	}

	@Override
	public List<AdminResource> getMenuTree(Long userId,String name,Boolean isAdmin) {
		List<AdminResource> list = new ArrayList<AdminResource>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userId", userId);
		map.put("name", name);
		map.put("isAdmin", isAdmin);
		try {
			list = resourceMapper.findResourceByNameAndUserId(map);
		} catch (Exception e) {
			logger.error("getMenuTree error",e);
		}
		List<AdminResource> tree = this.toTree(list);
		this.sort(tree);
		return tree;
	}

	@Override
	public List<AdminResource> getAllResource() {
		List<AdminResource> list = null;
		AdminResourceExample example = new AdminResourceExample();
		Criteria criteria = example.createCriteria();
		criteria.andUrlIsNotNull();
		try {
			list = resourceMapper.selectByExample(example);
		} catch (Exception e) {
			logger.error("getAllResource error",e);
		}
		return list;
	}
}
