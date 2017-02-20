package com.wqstore.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.wqstore.dao.AdminResourceMapper;
import com.wqstore.dao.AdminRoleMapper;
import com.wqstore.domain.AdminRole;
import com.wqstore.domain.AdminRoleExample;
import com.wqstore.result.DateUtil;
import com.wqstore.result.PageParam;
import com.wqstore.result.RequestPageVo;
import com.wqstore.result.RequestResultVo;
import com.wqstore.service.AdminRoleService;

@Service("roleService")
public class AdminRoleServiceImpl implements AdminRoleService{

	private static final Logger logger = LoggerFactory.getLogger(AdminRoleServiceImpl.class);
	
	@Resource
	private AdminRoleMapper roleMapper;
	
	@Resource
	private AdminResourceMapper resourceMapper;
	
	
	@Override
	public RequestPageVo<AdminRole> findRolePageList(AdminRole role,PageParam param) {
		RequestPageVo<AdminRole> page = new RequestPageVo<AdminRole>();
		AdminRoleExample example = new AdminRoleExample();
		if(role != null) {
			//查询条件
			AdminRoleExample.Criteria criteria = example.createCriteria();
			if(StringUtils.isNotBlank(role.getCode())) {
				criteria.andCodeEqualTo(role.getCode());
			}
			if(StringUtils.isNotBlank(role.getName())) {
				criteria.andNameEqualTo(role.getName());
			}
		}
		try {
			int count = roleMapper.countByExample(example);
			if (count > 0) {
				example.setStartPage(param.getOffset());
				example.setPageSize(param.getLimit());
				List<AdminRole> list = roleMapper.selectByExample(example);
				page.setTotal(count);
				page.setRows(list);
			}
		} catch (Exception e) {
			logger.error("findRolePageList error ",e);
		}
		return page;
	}

	@Override
	@Transactional
	public RequestResultVo<AdminRole> updateRole(AdminRole role) {
		RequestResultVo<AdminRole> result = new RequestResultVo<AdminRole>();
		if(role == null || role.getId() == null) {
			result.setSuccess(false);
			result.setErrorMessage("角色或角色ID不能为空！");
			return result;
		}
		role.setModifiedTime(DateUtil.getChineseTime());
		int count = roleMapper.updateByPrimaryKeySelective(role);
		if(count <=0 ){
			result.setSuccess(false);
			result.setErrorMessage("角色角色更新失败！");
		}
		return result;
	}

	@Override
	@Transactional
	public RequestResultVo<AdminRole> insertRole(AdminRole role) {
		RequestResultVo<AdminRole> result = new RequestResultVo<AdminRole>();
		List<AdminRole> list = null;
		if(role == null ) {
			result.setSuccess(false);
			result.setErrorMessage("角色信息不能为空！");
			return result;
		}
		role.setCreateTime(DateUtil.getChineseTime());
		AdminRoleExample example = new AdminRoleExample();
		AdminRoleExample.Criteria criteria = example.createCriteria();
		criteria.andCodeEqualTo(role.getCode());
		list = roleMapper.selectByExample(example);
		if(CollectionUtils.isEmpty(list)) {
			int count = roleMapper.insert(role);
			if(count <=0 ) {
				result.setSuccess(false);
				result.setErrorMessage("角色添加失败！");
			}
		}else {
			result.setSuccess(false);
			result.setErrorMessage("角色编码已存在！");
		}
		return result;
	}

	@Override
	@Transactional
	public RequestResultVo<AdminRole> deleteRole(Long id) {
		RequestResultVo<AdminRole> result = new RequestResultVo<AdminRole>();
		if(id == null) {
			result.setSuccess(false);
			result.setErrorMessage("角色ID不能为空");
			return result;
		}
		//判断角色是否被分配
		int rcount = roleMapper.findRoleAndUserRelationCount(id);
		if(rcount <= 0) {
			//解除角色与资源关系
			resourceMapper.deleteRoleAllResourceRelations(id);
			int count = roleMapper.deleteByPrimaryKey(id);
			if(count <= 0) {
				result.setSuccess(false);
				result.setErrorMessage("角色删除失败！");
			}
		}else {
			result.setSuccess(false);
			result.setErrorMessage("该角色下存在用户不能删除！");
		}
		return result;
	}
	
	@Override
	public List<AdminRole> findRoleByUserId(Long id) {
		List<AdminRole> list = null;
		if(id == null){
			return list;
		}
		try {
			list = roleMapper.findRoleByUserId(id);
		} catch (Exception e) {
			logger.error("findRoleByUserId error" ,e);
		}
		return list;
	}

	@Override
	public List<AdminRole> findRoleByNonUserId(Long id) {
		List<AdminRole> list = null;
		if(id == null) {
			return list;
		}
		try {
			list = roleMapper.findRoleByNonUserId(id);
		} catch (Exception e) {
			logger.error("findRoleByNonUserId error " ,e);
		}
		return list;
	}

	@Override
	public List<AdminRole> findAllRoles() {
		List<AdminRole> list = null;
		try {
			list = roleMapper.selectByExample(null);
		} catch (Exception e) {
			logger.error("findAllRoles error",e);
		}
		return list;
	}

}
