package com.example.dao;

import com.example.po.Detall;

public interface DetallMapper {
    int deleteByPrimaryKey(Long txDetallId);

    int insert(Detall record);

    int insertSelective(Detall record);

    Detall selectByPrimaryKey(Long txDetallId);

    int updateByPrimaryKeySelective(Detall record);

    int updateByPrimaryKey(Detall record);
}