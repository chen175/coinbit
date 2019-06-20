package com.example.controller;

import com.example.dao.DetallMapper;
import com.example.dao.TransacationMapper;
import com.example.dto.TransacationDto;
import com.example.po.Transacation;
import com.example.service.TransacationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/transacation")
@EnableAutoConfiguration
public class TransacationController {
    @Autowired
    private TransacationService transacationService;
    @Autowired
    private DetallMapper detailMapper;
    @GetMapping("/getRecentTransacation")
    public List<TransacationDto> getRecentTransacation() {
        List<TransacationDto> recentTransacation = transacationService.getRecentTransacation();
        for (TransacationDto transacationDto : recentTransacation) {
            String txhash = transacationDto.getTransactionHash();
            Double amount = detailMapper.getAmount(txhash);
            transacationDto.setAmount(amount);
        }
        return recentTransacation;
    }

    @GetMapping("/getTransacationByHash")
    public Transacation getTransacationByHash(@RequestParam String hash) {
        return transacationService.getTransacationByHash(hash);
    }
}
