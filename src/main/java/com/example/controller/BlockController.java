package com.example.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.api.BitcoinJsonRpcApi;
import com.example.api.BitcoinRestApi;
import com.example.dto.BlockListDto;
import com.example.po.Block;
import com.example.service.BlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/block")
public class BlockController {
    @Autowired
    private BitcoinRestApi bitcoinRestApi;
    @Autowired
    private BlockService blockService;

    @Autowired
    private BitcoinJsonRpcApi bitcoinJsonRpcApi;
    //todo
    @GetMapping("/getRecentBlocks")
    public List<BlockListDto> getRecentBlocks() throws Throwable {
        List<BlockListDto> recentBlocks = blockService.getRecentBlocks();
        return recentBlocks;
    }

    @GetMapping("/getByBlockhash")
    public Block getByBlockhash(@RequestParam String blockhash) {
        Block blockListDto = blockService.getBlockByHash(blockhash);
        return blockListDto;
    }

    @GetMapping("/getByHeight")
    public Block getByHeight(@RequestParam Integer height) {
        return blockService.getBlockByHeight(height);
    }

}
