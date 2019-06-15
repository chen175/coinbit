package com.example.controller;

import com.example.dto.BlockListDto;
import com.example.po.Block;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;

@RestController
@RequestMapping("/block")
public class BlockController {
    @GetMapping("/getRecentBlocks")
    public ArrayList<BlockListDto> getRecentBlocks(){
        ArrayList<BlockListDto> blockListDtos = new ArrayList<>();
        BlockListDto blockListDto = new BlockListDto();
        blockListDto.setBlockhash("00000000000000000025c889729b9f97cb3fc683742608fd61c7e481a7e2c951");
        blockListDto.setHeight(580770);
        blockListDto.setTime(new Date());
        blockListDto.setTransacation(2867);
        blockListDto.setMiner("SlushPool");
        blockListDto.setSize(1225.464);
        BlockListDto blockListDto2 = new BlockListDto();
        blockListDto2.setBlockhash("000000000000000000101451f546c34c144066c1f7d4e360de321a0bbf43dedb");
        blockListDto2.setHeight(580769);
        blockListDto2.setTime(new Date());
        blockListDto2.setTransacation(538);
        blockListDto2.setMiner("AntPool");
        blockListDto2.setSize(1773.224);
        blockListDtos.add(blockListDto);
        blockListDtos.add(blockListDto2);
        return blockListDtos;
    }
    @GetMapping("/getByBlockhash")
    public Block getByBlockhash(@RequestParam String blockhash){
        Block block = new Block();
        block.setBlockhash("00000000000000000006a0673f90d900aefe5f7bef705f7dbdabe9b7077e06dd");
        block.setDifficulty(7409399249090.25);
        block.setHeight(580768);
        block.setNextBlock("000000000000000000101451f546c34c144066c1f7d4e360de321a0bbf43dedb");
        block.setPrevBlock("00000000000000000001a138975ccd1ff91e4c7af0ce0d8b6b45ff806a6b7abe");
        block.setSize(1703.051);
        block.setTime(new Date());
        block.setWeight((float)3992.567);
        block.setTransacation(948);
        return block;
    }
    @GetMapping("/getByHeight")
    public Block getByHeight(@RequestParam Integer height){
        Block block = new Block();
        block.setBlockhash("00000000000000000006a0673f90d900aefe5f7bef705f7dbdabe9b7077e06dd");
        block.setDifficulty(7409399249090.25);
        block.setHeight(580768);
        block.setNextBlock("000000000000000000101451f546c34c144066c1f7d4e360de321a0bbf43dedb");
        block.setPrevBlock("00000000000000000001a138975ccd1ff91e4c7af0ce0d8b6b45ff806a6b7abe");
        block.setSize(1703.051);
        block.setTime(new Date());
        block.setWeight((float)3992.567);
        block.setTransacation(948);
        return block;
    }
}
