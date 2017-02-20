package com.wqstore.dao;

import com.wqstore.domain.UserCart;
import com.wqstore.domain.UserCartExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserCartMapper {
    int countByExample(UserCartExample example);

    int deleteByExample(UserCartExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserCart record);

    int insertSelective(UserCart record);

    List<UserCart> selectByExample(UserCartExample example);

    UserCart selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserCart record, @Param("example") UserCartExample example);

    int updateByExample(@Param("record") UserCart record, @Param("example") UserCartExample example);

    int updateByPrimaryKeySelective(UserCart record);

    int updateByPrimaryKey(UserCart record);
}