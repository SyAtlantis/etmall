package com.entanmo.etmall.core.service;

import com.entanmo.etmall.core.dao.GoodsProduct;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class GoodsProductService {

    @Resource
    private GoodsProduct goodsProduct;

    public int addStock(Integer id, Short num){
        return goodsProduct.addStock(id, num);
    }

    public int reduceStock(Integer id, Short num){
        return goodsProduct.reduceStock(id, num);
    }
}
