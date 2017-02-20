package com.wqstore.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.wqstore.domain.AdminRole;
import com.wqstore.domain.AdminRoleExample;

public interface AdminRoleMapper {
    int countByExample(AdminRoleExample example);

    int deleteByExample(AdminRoleExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AdminRole record);

    int insertSelective(AdminRole record);

    List<AdminRole> selectByExample(AdminRoleExample example);

    AdminRole selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AdminRole record, @Param("example") AdminRoleExample example);

    int updateByExample(@Param("record") AdminRole record, @Param("example") AdminRoleExample example);

    int updateByPrimaryKeySelective(AdminRole record);

    int updateByPrimaryKey(AdminRole record);
    
    
    List<AdminRole> findRoleByUserId(Long userId);
    
    List<AdminRole> findRoleByNonUserId(Long userId);
    
    //删除用户角色关系
    int deleteUserRoleRelation(Map<String, Object> map);
	
    //添加用户角色关系
	int addUserRoleRelation(Map<String, Object> map);

	//删除用户所有角色关系
	void deleteUserAllRoleRelations(Long user_id);

	//查询用户和角色关系数
	int findRoleAndUserRelationCount(Long role_id);
}