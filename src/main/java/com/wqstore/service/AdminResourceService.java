package com.wqstore.service;

import java.util.List;

import com.wqstore.domain.AdminResource;
import com.wqstore.result.RequestResultVo;

public interface AdminResourceService {

	/**
	 * 查询资源树
	 * @return
	 */
	List<AdminResource> getResourceTree();

	/**
	 * 更新资源
	 * @param resource
	 * @return
	 */
	RequestResultVo<AdminResource> updateResource(AdminResource resource);

	/**
	 * 保存资源
	 * @param resource
	 * @return
	 */
	RequestResultVo<AdminResource> insertResource(AdminResource resource);

	/**
	 * 删除资源
	 * @param id
	 * @return
	 */
	RequestResultVo<AdminResource> deleteResource(Long id);

	/**
	 * 根据id查询资源信息
	 * @param id
	 * @return
	 */
	AdminResource findResourceById(Long id);

	/**
	 * 根据角色id查询资源树
	 * @param id
	 * @return
	 */
	List<AdminResource> getResourceTreeByRoleId(Long id);

	/**
	 * 根据角色id查询未授予资源
	 * @param id
	 * @return
	 */
	List<AdminResource> getResourceTreeByNonRoleId(Long id);

	/**
	 * 添加角色资源
	 * @param resourceIds
	 * @param roleId
	 * @return
	 */
	RequestResultVo<AdminResource> addRoleResource(List<Long> resourceIds,Long roleId);

	/**
	 * 删除角色资源
	 * @param resourceIds
	 * @param roleId
	 * @return
	 */
	RequestResultVo<AdminResource> deleteRoleResource(List<Long> resourceIds,Long roleId);

	/**
	 * 根据角色id获取资源
	 * @param roleIds
	 * @return
	 */
	List<AdminResource> findResourceByRoleIds(List<Long> roleIds);

	/**
	 * 根据用户id和关键字获得菜单树
	 * @return
	 */
	List<AdminResource> getMenuTree(Long userId,String name, Boolean isAdmin);

	/**
	 * 获得所有有url的资源
	 * @return
	 */
	List<AdminResource> getAllResource();
	
}
