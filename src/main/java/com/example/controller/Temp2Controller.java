package com.example.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.api.BitcoinRestApi;
import com.googlecode.jsonrpc4j.JsonRpcHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URL;
import java.util.Base64;
import java.util.HashMap;

@RequestMapping("/temp2")
@RestController
public class Temp2Controller {
    @Autowired
    private BitcoinRestApi bitcoinRestApi;

    @GetMapping("/test")
    public String test() throws Throwable {
//        HashMap<String, String> headers = new HashMap<>();
//        String authStrOrig = "chensir:123456";
//        String authStr = Base64.getEncoder().encodeToString(authStrOrig.getBytes());
//        String authStrResult = String.format("Basic %s",authStr);
//        headers.put("Authorization",authStrResult);
//
//        JsonRpcHttpClient client = new JsonRpcHttpClient(new URL("http://localhost:18332"),headers);
//
//        JSONObject user = client.invoke("getblockchaininfo", new Object[]{}, JSONObject.class);
//        JSONObject blockChainInfo = bitcoinRestApi.getBlockChainInfo();
        JSONObject blockByHash = bitcoinRestApi.getBlockByHash("0000000000000453e8ca7b4407b35b5dddb6eda44a163f97215a2fd6b545285f");
        JSONObject transaction = bitcoinRestApi.getTransaction("715e13120743d218cb4c6842ab9883bf5482802b3f190fac2e6c43228cdb5cdf");
        return null;
    }
}
