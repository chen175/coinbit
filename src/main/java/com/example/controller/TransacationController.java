package com.example.controller;

import com.example.dao.TransacationMapper;
import com.example.dto.TransacationDto;
import com.example.po.Transacation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/transacation")
@EnableAutoConfiguration
public class TransacationController {
    @Autowired
    private TransacationMapper transacationMapper;
    @GetMapping("/getRecentTransacation")
    public TransacationDto getRecentTransacation(){
        TransacationDto transacationDto = new TransacationDto();
        transacationDto.setTransactionHash("c09a5947c95d4ce714b82529eb8289b17f8395087bc8085cbcab9e6c3f194bfa");
        transacationDto.setAmount(0.02423692);
        transacationDto.setTime(new Date());
        return transacationDto;
    }
    @GetMapping("/getTransacationByHash")
    public Transacation getRecentTransacation(@RequestParam String hash){
        Transacation transacation = new Transacation();
        transacation.setAmout(0.02423692);
        transacation.setBlockhash("b2e3c93266d063c6f633565fe8523842516ef8d13b09629df86fb821cc894f4f");
        transacation.setConfirmations(200);
        transacation.setSize(216);
        transacation.setTime(new Date());
        transacation.setTxhash("b2e3c93266d063c6f633565fe8523842516ef8d13b09629df86fb821cc894f4f");
        transacation.setWeight((float) 534);
        return transacation;
    }
}
