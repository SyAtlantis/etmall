package com.entanmo.etmall.core.service;

import com.entanmo.etmall.core.dao.IGoodsProduct;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class GoodsProductService {

    @Resource
    private IGoodsProduct goodsProduct;

    public int addStock(Integer id, Short num){
        return goodsProduct.addStock(id, num);
    }

    public int reduceStock(Integer id, Short num){
        return goodsProduct.reduceStock(id, num);
    }
}
