package com.example.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.api.BitcoinJsonRpcApi;
import com.example.api.BitcoinRestApi;
import com.example.dto.BlockListDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;

@RestController
@RequestMapping("/block")
public class BlockController {
    @Autowired
    private BitcoinRestApi bitcoinRestApi;

    @Autowired
    private BitcoinJsonRpcApi bitcoinJsonRpcApi;
    @GetMapping("/getRecentBlocks")
    public ArrayList<BlockListDto> getRecentBlocks() throws Throwable {
        ArrayList<BlockListDto> blockListDtos = new ArrayList<>();
        BlockListDto blockListDto = new BlockListDto();
        JSONObject blockChainInfo1 = bitcoinRestApi.getBlockChainInfo();
        Integer blockHeight = blockChainInfo1.getInteger("blocks");
        Integer blockheight2 = blockHeight - 5;

        String blockHashByHeight = bitcoinJsonRpcApi.getBlockHashByHeight(blockheight2);
        JSONArray blockHeaders = bitcoinRestApi.getBlockHeaders(5, blockHashByHeight);
//        blockListDto.setBlockhash("00000000000000000025c889729b9f97cb3fc683742608fd61c7e481a7e2c951");
//        blockListDto.setHeight(580770);
//        blockListDto.setTime(new Date());
//        blockListDto.setTransacation(2867);
//        blockListDto.setMiner("SlushPool");
//        blockListDto.setSize(1225.464);
//        BlockListDto blockListDto2 = new BlockListDto();
//        blockListDto2.setBlockhash("000000000000000000101451f546c34c144066c1f7d4e360de321a0bbf43dedb");
//        blockListDto2.setHeight(580769);
//        blockListDto2.setTime(new Date());
//        blockListDto2.setTransacation(538);
//        blockListDto2.setMiner("AntPool");
//        blockListDto2.setSize(1773.224);
//        blockListDtos.add(blockListDto);
//        blockListDtos.add(blockListDto2);
        for (Object blockHeader : blockHeaders) {
            JSONObject jsonObject = (JSONObject) blockHeader;
            blockListDto.setBlockhash(jsonObject.getString("hash"));
            blockListDto.setHeight(jsonObject.getInteger("height"));
            blockListDto.setTime(new Date(1000*jsonObject.getLong("time")));
            blockListDto.setTransacation(jsonObject.getInteger("nTx"));
            blockListDto.setMiner("SlushPool");
            blockListDto.setSize(1225.464);
            blockListDtos.add(blockListDto);
        }
        return blockListDtos;
    }

    @GetMapping("/getByBlockhash")
    public JSONObject getByBlockhash(@RequestParam String blockhash) {

        return bitcoinRestApi.getBlockByHash(blockhash);
    }

    @GetMapping("/getByHeight")
    public JSONObject getByHeight(@RequestParam Integer height) {
        return bitcoinRestApi.getBlockByHeight(height);
    }

}
