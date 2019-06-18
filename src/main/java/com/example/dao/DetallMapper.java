package com.example.dao;

import com.example.po.Detall;

public interface DetallMapper {
    int deleteByPrimaryKey(String txDetallId);

    int insert(Detall record);

    int insertSelective(Detall record);

    Detall selectByPrimaryKey(String txDetallId);

    int updateByPrimaryKeySelective(Detall record);

    int updateByPrimaryKey(Detall record);
}