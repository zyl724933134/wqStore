package com.wqstore.service;

import java.util.List;

import com.wqstore.domain.AdminRole;
import com.wqstore.domain.AdminUser;
import com.wqstore.result.PageParam;
import com.wqstore.result.RequestPageVo;
import com.wqstore.result.RequestResultVo;


public interface AdminUserService {
	
	/**
	 * 分页查询用户列表
	 * @param user
	 * @param param
	 * @return
	 */
	RequestPageVo<AdminUser> findUserPageList(AdminUser user, PageParam param);

	/**
	 * 更新用户信息
	 * @param user
	 * @return
	 */
	RequestResultVo<AdminUser> updateUser(AdminUser user);

	/**
	 * 添加用户
	 * @param user
	 * @return
	 */
	RequestResultVo<AdminUser> insertUser(AdminUser user);

	/**
	 * 删除用户
	 * @param id
	 * @return
	 */
	RequestResultVo<AdminUser> deleteUser(Long id);


	/**
	 * 根据用户id删除
	 * @param ids
	 * @return
	 */
	RequestResultVo<AdminRole> deleteUserRole(List<Long> roleIds, Long userId);

	/**
	 * 根据用户id添加角色
	 * @param ids
	 * @param userId 
	 * @return
	 */
	RequestResultVo<AdminRole> addUserRole(List<Long> roleIds, Long userId);

	/**
	 * 根据登录名查询用户
	 * @param loginName
	 * @return
	 */
	AdminUser findUserByLoginName(String loginName);

	/**
	 * 重置用户密码
	 * @param id
	 * @return
	 */
	RequestResultVo<AdminUser> resetUserPassword(Long id);

	/**
	 * 更新用户密码
	 * @param oldPassword
	 * @param password
	 * @return
	 */
	RequestResultVo<String> updatePassword(String name,String oldPassword, String password);

	/**
	 * 根据用户id查询用户
	 * @param userId
	 * @return
	 */
	AdminUser findUserById(Long userId);
	
	boolean checkUser(String name,String pwd);
}
