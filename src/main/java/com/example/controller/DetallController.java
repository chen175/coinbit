package com.example.controller;

import com.example.dao.DetallMapper;
import com.example.po.Detall;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/detall")

public class DetallController {
    @Autowired
    private DetallMapper detallMapper;
    @RequestMapping("/getDetallByHash")
    public Detall getDetallByHash(@RequestParam String hash){
        Detall detall = new Detall();
        detall.setAdress("\t1GPvNB8q9Da3ddzfjrheoLs8ifLtWZwwYK");
        detall.setAmount(0.26406749);
        detall.setTxDetallId("a8df95b843b9f4d670e6cf42bd3a937c0d9cf9b0");
        detall.setType((byte) 1);
        detall.setTxhash("2208e62ef4f0fa751261f0788a7efd98964de9888342c862f373f77cdfebb031");
        return detall;
    }
}
