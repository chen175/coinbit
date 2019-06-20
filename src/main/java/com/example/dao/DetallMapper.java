package com.example.dao;

import com.example.po.Detall;
import org.apache.ibatis.annotations.Param;

public interface DetallMapper {
    int deleteByPrimaryKey(String txDetallId);

    int insert(Detall record);

    int insertSelective(Detall record);

    Detall selectByPrimaryKey(String txDetallId);

    int updateByPrimaryKeySelective(Detall record);

    int updateByPrimaryKey(Detall record);

    Double getAmount(String txhash);

}