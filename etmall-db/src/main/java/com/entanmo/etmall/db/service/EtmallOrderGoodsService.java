package com.entanmo.etmall.db.service;


import com.entanmo.etmall.db.dao.EtmallOrderGoodsMapper;
import com.entanmo.etmall.db.domain.EtmallOrderGoods;
import com.entanmo.etmall.db.domain.EtmallOrderGoodsExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class EtmallOrderGoodsService {

    @Resource
    private EtmallOrderGoodsMapper orderGoodsMapper;

    public int add(EtmallOrderGoods orderGoods) {
        orderGoods.setAddTime(LocalDateTime.now());
        orderGoods.setUpdateTime(LocalDateTime.now());
        return orderGoodsMapper.insertSelective(orderGoods);
    }

    public List<EtmallOrderGoods> queryByOid(Integer orderId) {
        EtmallOrderGoodsExample example = new EtmallOrderGoodsExample();
        example.or().andOrderIdEqualTo(orderId).andDeletedEqualTo(false);
        return orderGoodsMapper.selectByExample(example);
    }

    public List<EtmallOrderGoods> findByOidAndGid(Integer orderId, Integer goodsId) {
        EtmallOrderGoodsExample example = new EtmallOrderGoodsExample();
        example.or().andOrderIdEqualTo(orderId).andGoodsIdEqualTo(goodsId).andDeletedEqualTo(false);
        return orderGoodsMapper.selectByExample(example);
    }

    public EtmallOrderGoods findById(Integer id) {
        return orderGoodsMapper.selectByPrimaryKey(id);
    }

    public void updateById(EtmallOrderGoods orderGoods) {
        orderGoods.setUpdateTime(LocalDateTime.now());
        orderGoodsMapper.updateByPrimaryKeySelective(orderGoods);
    }

    public Short getComments(Integer orderId) {
        EtmallOrderGoodsExample example = new EtmallOrderGoodsExample();
        example.or().andOrderIdEqualTo(orderId).andDeletedEqualTo(false);
        long count = orderGoodsMapper.countByExample(example);
        return (short) count;
    }

    public boolean checkExist(Integer goodsId) {
        EtmallOrderGoodsExample example = new EtmallOrderGoodsExample();
        example.or().andGoodsIdEqualTo(goodsId).andDeletedEqualTo(false);
        return orderGoodsMapper.countByExample(example) != 0;
    }
}
