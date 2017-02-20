package com.wqstore.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.wqstore.domain.AdminResource;
import com.wqstore.domain.AdminResourceExample;

public interface AdminResourceMapper {
    int countByExample(AdminResourceExample example);

    int deleteByExample(AdminResourceExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AdminResource record);

    int insertSelective(AdminResource record);

    List<AdminResource> selectByExample(AdminResourceExample example);

    AdminResource selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AdminResource record, @Param("example") AdminResourceExample example);

    int updateByExample(@Param("record") AdminResource record, @Param("example") AdminResourceExample example);

    int updateByPrimaryKeySelective(AdminResource record);

    int updateByPrimaryKey(AdminResource record);
   
    List<String> findExcResourceCodeById(Long id);

	List<AdminResource> findResourceByRoleId(Long id);

	List<AdminResource> findResourceByNonRoleId(Long id);
    
    int addRoleResourceRelation(Map<String, Object> map);
    
    int deleteRoleResourceRelation(Map<String, Object> map);

	void deleteRoleAllResourceRelations(Long roleId);
    
    //根据角色查询资源
    List<AdminResource> findResourceByRoleIds(List<Long> roleIds);

    //根据用户id查询资源
	List<AdminResource> findResourceByNameAndUserId(Map<String, Object> map);
}