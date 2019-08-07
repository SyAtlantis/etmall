package com.entanmo.etmall.db.service;

import com.entanmo.etmall.db.dao.EtmallGoodsAttributeMapper;
import com.entanmo.etmall.db.domain.EtmallGoodsAttribute;
import com.entanmo.etmall.db.domain.EtmallGoodsAttributeExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class EtmallGoodsAttributeService {

    @Resource
    private EtmallGoodsAttributeMapper goodsAttributeMapper;

    public List<EtmallGoodsAttribute> queryByGid(Integer goodsId) {
        EtmallGoodsAttributeExample example = new EtmallGoodsAttributeExample();
        example.or().andGoodsIdEqualTo(goodsId).andDeletedEqualTo(false);
        return goodsAttributeMapper.selectByExample(example);
    }

    public void add(EtmallGoodsAttribute goodsAttribute) {
        goodsAttribute.setAddTime(LocalDateTime.now());
        goodsAttribute.setUpdateTime(LocalDateTime.now());
        goodsAttributeMapper.insertSelective(goodsAttribute);
    }

    public EtmallGoodsAttribute findById(Integer id) {
        return goodsAttributeMapper.selectByPrimaryKey(id);
    }

    public void deleteByGid(Integer gid) {
        EtmallGoodsAttributeExample example = new EtmallGoodsAttributeExample();
        example.or().andGoodsIdEqualTo(gid);
        goodsAttributeMapper.logicalDeleteByExample(example);
    }
}
