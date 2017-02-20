package com.wqstore.dao;

import com.wqstore.domain.SellOrderItem;
import com.wqstore.domain.SellOrderItemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SellOrderItemMapper {
    int countByExample(SellOrderItemExample example);

    int deleteByExample(SellOrderItemExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SellOrderItem record);

    int insertSelective(SellOrderItem record);

    List<SellOrderItem> selectByExample(SellOrderItemExample example);

    SellOrderItem selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SellOrderItem record, @Param("example") SellOrderItemExample example);

    int updateByExample(@Param("record") SellOrderItem record, @Param("example") SellOrderItemExample example);

    int updateByPrimaryKeySelective(SellOrderItem record);

    int updateByPrimaryKey(SellOrderItem record);
}