package com.entanmo.etmall.db.service;


import com.entanmo.etmall.db.dao.EtmallGoodsProductMapper;
import com.entanmo.etmall.db.domain.EtmallGoodsProduct;
import com.entanmo.etmall.db.domain.EtmallGoodsProductExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class EtmallGoodsProductService {

    @Resource
    private EtmallGoodsProductMapper EtmallGoodsProductMapper;
//    @Resource
//    private GoodsProduct goodsProduct;

    public List<EtmallGoodsProduct> queryByGid(Integer gid) {
        EtmallGoodsProductExample example = new EtmallGoodsProductExample();
        example.or().andGoodsIdEqualTo(gid).andDeletedEqualTo(false);
        return EtmallGoodsProductMapper.selectByExample(example);
    }

    public EtmallGoodsProduct findById(Integer id) {
        return EtmallGoodsProductMapper.selectByPrimaryKey(id);
    }

    public void deleteById(Integer id) {
        EtmallGoodsProductMapper.logicalDeleteByPrimaryKey(id);
    }

    public void add(EtmallGoodsProduct goodsProduct) {
        goodsProduct.setAddTime(LocalDateTime.now());
        goodsProduct.setUpdateTime(LocalDateTime.now());
        EtmallGoodsProductMapper.insertSelective(goodsProduct);
    }

    public int count() {
        EtmallGoodsProductExample example = new EtmallGoodsProductExample();
        example.or().andDeletedEqualTo(false);
        return (int) EtmallGoodsProductMapper.countByExample(example);
    }

    public void deleteByGid(Integer gid) {
        EtmallGoodsProductExample example = new EtmallGoodsProductExample();
        example.or().andGoodsIdEqualTo(gid);
        EtmallGoodsProductMapper.logicalDeleteByExample(example);
    }

//    public int addStock(Integer id, Short num){
//        return goodsProduct.addStock(id, num);
//    }
//
//    public int reduceStock(Integer id, Short num){
//        return goodsProduct.reduceStock(id, num);
//    }
}