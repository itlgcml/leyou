package com.leyou.item.service;

import com.leyou.item.mapper.SpuMapper;
import com.leyou.item.pojo.Spu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class GoodService {

    @Autowired
    private SpuMapper spuMapper;

    public List<Spu> querySpuByPage(String key, Integer saleable) {
        Example example = new Example(Spu.class);
        Example saleIs = new Example(Spu.class);
        key = "%" + key + "%";
        example.createCriteria().andLike("title",key).andEqualTo("valid","1");
        if (-1 != saleable){
            example.and(saleIs.createCriteria().andEqualTo("saleable",saleable));
        }
        List<Spu> spuList = spuMapper.selectByExample(example);
        return spuList;
    }
}
