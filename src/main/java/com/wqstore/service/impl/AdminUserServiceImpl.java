package com.wqstore.service.impl;

import java.util.ArrayList;
import java.util.Date;
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

import com.wqstore.dao.AdminRoleMapper;
import com.wqstore.dao.AdminUserMapper;
import com.wqstore.domain.AdminRole;
import com.wqstore.domain.AdminUser;
import com.wqstore.domain.AdminUserExample;
import com.wqstore.domain.AdminUserExample.Criteria;
import com.wqstore.result.DateUtil;
import com.wqstore.result.PageParam;
import com.wqstore.result.RequestPageVo;
import com.wqstore.result.RequestResultVo;
import com.wqstore.service.AdminUserService;

@Service("userService")
public class AdminUserServiceImpl implements AdminUserService {
	private static final Logger logger = LoggerFactory.getLogger(AdminUserServiceImpl.class);
	
	private static final String INIT_PASSWORD = "123456";
	
	@Resource
	private AdminUserMapper userMapper;
	
	@Resource
	private AdminRoleMapper roleMapper;
	
	@Override
	public RequestPageVo<AdminUser> findUserPageList(AdminUser user, PageParam param) {
		RequestPageVo<AdminUser> page = new RequestPageVo<AdminUser>();
		
		AdminUserExample example = new AdminUserExample();
		if(user != null) {
//			查询条件
			AdminUserExample.Criteria criteria = example.createCriteria();
			if(StringUtils.isNotBlank(user.getLoginName())){
				criteria.andLoginNameEqualTo(user.getLoginName());
			}
			if(StringUtils.isNotBlank(user.getRealName())) {
				criteria.andRealNameEqualTo(user.getRealName());
			}
			if(user.getStatus() != null) {
				criteria.andStatusEqualTo(user.getStatus());
			}
		}
		try {
			int count = userMapper.countByExample(example);
			if(count > 0) {
				example.setStartPage(param.getOffset());
				example.setPageSize(param.getLimit());
				List<AdminUser> list = userMapper.selectByExample(example);
				this.getUserRoles(list);
				page.setRows(list);
				page.setTotal(count);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("findUserPageList error " , e);
		}
		return page;
	}

	@Override
	@Transactional
	public RequestResultVo<AdminUser> updateUser(AdminUser user) {
		RequestResultVo<AdminUser> result = new RequestResultVo<AdminUser>();
		if(user == null || user.getId() == null) {
			result.setSuccess(false);
			result.setErrorMessage("用户信息和用户ID不能为空！");
			return result;
		}
		
		user.setModifiedTime(DateUtil.getChineseTime());
		int count = 0;
		try {
			count = userMapper.updateByPrimaryKeySelective(user);
		} catch (Exception e) {
			logger.error("updateUser error " ,e);
		}
		if(count <= 0 ){
			result.setSuccess(false);
			result.setErrorMessage("用户更新失败！");
		}
		return result;
	}

	@Override
	@Transactional
	public RequestResultVo<AdminUser> insertUser(AdminUser user) {
		RequestResultVo<AdminUser> result = new RequestResultVo<AdminUser>();
		if(user == null) {
			result.setSuccess(false);
			result.setErrorMessage("用户信息不能为空！");
			return result;
		}
		
		//验证用户名是否存在
		AdminUserExample example = new AdminUserExample();
		AdminUserExample.Criteria criteria = example.createCriteria();
		criteria.andLoginNameEqualTo(user.getLoginName());
		List<AdminUser> list = userMapper.selectByExample(example);
		if(!CollectionUtils.isEmpty(list)) {
			result.setSuccess(false);
			result.setErrorMessage("该用户已存在！");
			return result;
		}
		user.setCreateTime(new Date());
		
		int count = userMapper.insert(user);
		if(count <= 0 ){
			result.setSuccess(false);
			result.setErrorMessage("用户添加失败！");
		}
		return result;
	}

	@Override
	@Transactional
	public RequestResultVo<AdminUser> deleteUser(Long id) {
		RequestResultVo<AdminUser> result = new RequestResultVo<AdminUser>();
		if(id == null) {
			result.setSuccess(false);
			result.setErrorMessage("用户ID不能为空！");
			return result;
		}
		//解除该用户所有的角色关系
		roleMapper.deleteUserAllRoleRelations(id);
		int count = userMapper.deleteByPrimaryKey(id);
		if(count <= 0) {
			result.setSuccess(false);
			result.setErrorMessage("该用户ID不存在！");
		}
		return result;
	}

	@Override
	@Transactional
	public RequestResultVo<AdminRole> deleteUserRole(List<Long> roleIds, Long userId) {
		RequestResultVo<AdminRole> result = new RequestResultVo<AdminRole>();
		Map<String, Object> map = new HashMap<String, Object>();
		if(CollectionUtils.isEmpty(roleIds) || userId == null) {
			result.setSuccess(false);
			result.setErrorMessage("用户id和角色id不能为空！");
			return result;
		}
		map.put("userId", userId);
		map.put("roleIds", roleIds);
		int count = roleMapper.deleteUserRoleRelation(map);
		if(count <=0 ) {
			result.setSuccess(false);
			result.setErrorMessage("用户删除角色失败！");
		}
		return result;
	}

	@Override
	@Transactional
	public RequestResultVo<AdminRole> addUserRole(List<Long> roleIds, Long userId) {
		RequestResultVo<AdminRole> result = new RequestResultVo<AdminRole>();
		Map<String, Object> map = new HashMap<String, Object>();
		if(CollectionUtils.isEmpty(roleIds) || userId == null) {
			result.setSuccess(false);
			result.setErrorMessage("用户id和角色id不能为空！");
			return result;
		}
		map.put("userId", userId);
		map.put("roleIds", roleIds);
		int count = roleMapper.addUserRoleRelation(map);
		if(count <=0 ) {
			result.setSuccess(false);
			result.setErrorMessage("用户添加角色失败！");
		}
		return result;
	}

	@Override
	public AdminUser findUserByLoginName(String loginName) {
		List<AdminUser> list = null;
		AdminUserExample example = new AdminUserExample();
		AdminUserExample.Criteria criteria = example.createCriteria();
		criteria.andLoginNameEqualTo(loginName);
		try {
			 list = userMapper.selectByExample(example);
		} catch (Exception e) {
			logger.error("findUserByLoginName error",e);
		}
		if(list!=null && list.size()==1){
			return list.get(0);
		}
		return null;
	}

	private List<AdminUser> getUserRoles(List<AdminUser> list) {
		for (AdminUser user : list) {
			List<String> roles = new ArrayList<String>();
			List<AdminRole> rList = roleMapper.findRoleByUserId(user.getId());
			for (AdminRole role : rList) {
				roles.add(role.getName());
			}
			user.setRoles(roles);
		}
		return list;
	}

	@Override
	public RequestResultVo<AdminUser> resetUserPassword(Long id) {
		RequestResultVo<AdminUser> result = new RequestResultVo<AdminUser>();
		if(id == null) {
			result.setSuccess(false);
			result.setErrorMessage("用户ID不能为空！");
			return result;
		}
		AdminUser user = new AdminUser();
		user.setId(id);
		user.setPassword(INIT_PASSWORD);
		userMapper.updateByPrimaryKeySelective(user);
		return result;
	}

	@Override
	public RequestResultVo<String> updatePassword(String loginName,String oldPassword,
			String password) {
		RequestResultVo<String> result = new RequestResultVo<String>();
		AdminUser user = this.findUserByLoginName(loginName);
		if(user != null && user.getPassword()!= null) {
			if(!user.getPassword().equals(oldPassword)) {
				result.setSuccess(false);
				result.setErrorMessage("旧密码错误！");
				return result;
			}
			
			if(oldPassword.equals(password)) {
				result.setSuccess(false);
				result.setErrorMessage("新密码不能和旧密码一致！");
				return result;
			}
			//更新用户密码
			user.setPassword(password);
			userMapper.updateByPrimaryKeySelective(user);
			
		}
		return result;
	}

	@Override
	public AdminUser findUserById(Long userId) {
		return userMapper.selectByPrimaryKey(userId);
	}

	@Override
	public boolean checkUser(String name, String pwd) {
		AdminUserExample example = new AdminUserExample();
		Criteria criteria = example.createCriteria();
		criteria.andLoginNameEqualTo(name);
		criteria.andPasswordEqualTo(pwd);
		List<AdminUser> user = userMapper.selectByExample(example);
		if(!CollectionUtils.isEmpty(user)){
			return true;
		}
		return false;
	}
}
