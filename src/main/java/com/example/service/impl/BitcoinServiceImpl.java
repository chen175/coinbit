package com.example.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.dao.TransacationMapper;
import com.example.po.Transacation;
import com.example.service.BitcoinService;
import com.example.api.BitcoinRestApi;
import com.example.dao.BlockMapper;
import com.example.po.Block;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

@Service
public class BitcoinServiceImpl implements BitcoinService {
    @Autowired
    private BitcoinRestApi bitcoinRestApi;
    @Autowired
    private BlockMapper blockMapper;
    @Autowired
    private TransacationMapper transacationMapper;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    @Async
    @Transactional
    public void syncBlock(String blockhash) {
        logger.info("begin to sync block from {}", blockhash);
        String tempBlockhash = blockhash;
        while (tempBlockhash != null && !tempBlockhash.isEmpty()) {
            JSONObject blockByHash = bitcoinRestApi.getBlockByHash(tempBlockhash);
            Block block = new Block();
            block.setBlockhash(blockByHash.getString("hash"));
            block.setHeight(blockByHash.getInteger("height"));
            Long timestamp = blockByHash.getLong("time");
            Date time = new Date(timestamp * 1000);
            block.setTime(time);
            block.setSize(blockByHash.getInteger("size"));
            block.setDifficulty(blockByHash.getDouble("difficulty"));
            block.setWeight(blockByHash.getFloat("weight"));
            block.setNextBlock(blockByHash.getString("nextblockhash"));
            block.setPrevBlock(blockByHash.getString("previousblockhash"));
            block.setTransacation(blockByHash.getInteger("nTx"));
            Integer confirmations = blockByHash.getInteger("confirmations");
            blockMapper.insertSelective(block);

            //tx
            JSONArray tx = blockByHash.getJSONArray("tx");
            for (Object o : tx) {
                JSONObject jsonObject = new JSONObject((LinkedHashMap) o);
                syncTx(jsonObject, tempBlockhash, time, confirmations);
            }
            tempBlockhash = block.getNextBlock();
        }
        logger.info("end sync block ");
    }

    @Override
    @Transactional
    public void syncTx(JSONObject txJson, String blockhash, Date time, Integer confirmations) {
        Transacation transacation = new Transacation();
        transacation.setTxhash(txJson.getString("txid"));
        transacation.setTime(time);
        transacation.setBlockhash(blockhash);
        transacation.setSize(txJson.getInteger("size"));
        transacation.setWeight(txJson.getFloat("weight"));
        transacation.setConfirmations(confirmations);
        transacationMapper.insertSelective(transacation);

        syncTxDetail(txJson);
    }

    @Override
    @Transactional
    public void syncTxDetail(JSONObject txjson) {
        JSONArray vout = txjson.getJSONArray("vout");
        syncDetailvout(vout);
        JSONArray vin = txjson.getJSONArray("vin");
        syncDetailvin(vin);
    }

    @Override
    public void syncDetailvin(JSONArray vins) {

    }

    @Override
    public void syncDetailvout(JSONArray vouts) {
        for (Object vout : vouts) {
            JSONObject jsonObject = new JSONObject((LinkedHashMap) vout);
        }
    }


}
