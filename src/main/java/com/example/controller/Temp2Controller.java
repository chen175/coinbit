package com.example.controller;

import com.example.service.BitcoinService;
import com.example.api.BitcoinRestApi;
import com.example.dao.BlockMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/temp2")
@RestController
public class Temp2Controller {
    @Autowired
    private BitcoinRestApi bitcoinRestApi;
    @Autowired
    private BlockMapper blockMapper;
    @Autowired
    private BitcoinService bitcoinService;

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
//        JSONObject blockByHash = bitcoinRestApi.getBlockByHash("0000000000000453e8ca7b4407b35b5dddb6eda44a163f97215a2fd6b545285f");
//        JSONObject transaction = bitcoinRestApi.getTransaction("715e13120743d218cb4c6842ab9883bf5482802b3f190fac2e6c43228cdb5cdf");
        String tempBlockhash = "000000000000233556fd1d52a206aa4973c4ad74f5bdb47f417864ea7765a408";
        bitcoinService.syncBlock(tempBlockhash);
        return null;
    }


}
