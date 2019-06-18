package com.example.service.impl;

import com.example.dao.TransacationMapper;
import com.example.dto.TransacationDto;
import com.example.po.Transacation;
import com.example.service.TransacationService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TransacationServiceImpl implements TransacationService {
    @Autowired
    private TransacationMapper transacationMapper;

    @Override
    public List<TransacationDto> getRecentTransacation() {
        return transacationMapper.getRecentTransacation();
    }

    @Override
    public Transacation getTransacationByHash(String hash) {
        return transacationMapper.getTransacationByHash(hash);
    }
}
