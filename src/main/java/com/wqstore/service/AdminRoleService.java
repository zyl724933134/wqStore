package com.wqstore.service;

import java.util.List;

import com.wqstore.domain.AdminRole;
import com.wqstore.result.PageParam;
import com.wqstore.result.RequestPageVo;
import com.wqstore.result.RequestResultVo;

public interface AdminRoleService {

	/**
	 * 分页查询角色列表
	 * @param param
	 * @param role
	 * @return
	 */
	RequestPageVo<AdminRole> findRolePageList(AdminRole role, PageParam param);

	
	/**
	 * 更新角色信息
	 * @param role
	 * @return
	 */
	RequestResultVo<AdminRole> updateRole(AdminRole role);

	/**
	 * 添加角色
	 * @param role
	 * @return
	 */
	RequestResultVo<AdminRole> insertRole(AdminRole role);

	/**
	 * 删除角色
	 * @param id
	 * @return
	 */
	RequestResultVo<AdminRole> deleteRole(Long id);
	
	/**
	 * 根据用户id查询拥有的角色
	 * @param id
	 * @return
	 */
	List<AdminRole> findRoleByUserId(Long id);

	/**
	 * 根据用户id查询未拥有的角色
	 * @param id
	 * @return
	 */
	List<AdminRole> findRoleByNonUserId(Long id);


	/**
	 * 获取所有角色
	 * @return
	 */
	List<AdminRole> findAllRoles();

}
