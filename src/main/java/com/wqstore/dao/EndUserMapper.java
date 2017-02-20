package com.wqstore.dao;

import com.wqstore.domain.EndUser;
import com.wqstore.domain.EndUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EndUserMapper {
    int countByExample(EndUserExample example);

    int deleteByExample(EndUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EndUser record);

    int insertSelective(EndUser record);

    List<EndUser> selectByExample(EndUserExample example);

    EndUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") EndUser record, @Param("example") EndUserExample example);

    int updateByExample(@Param("record") EndUser record, @Param("example") EndUserExample example);

    int updateByPrimaryKeySelective(EndUser record);

    int updateByPrimaryKey(EndUser record);
}