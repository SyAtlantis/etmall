package com.entanmo.etmall.db.service;

import com.entanmo.etmall.db.dao.EtmallFootprintMapper;
import com.entanmo.etmall.db.domain.EtmallFootprint;
import com.entanmo.etmall.db.domain.EtmallFootprintExample;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class EtmallFootprintService {

    @Resource
    private EtmallFootprintMapper footprintMapper;

    public List<EtmallFootprint> queryByAddTime(Integer userId, Integer page, Integer size) {
        EtmallFootprintExample example = new EtmallFootprintExample();
        example.or().andUserIdEqualTo(userId).andDeletedEqualTo(false);
        example.setOrderByClause(EtmallFootprint.Column.addTime.desc());
        PageHelper.startPage(page, size);
        return footprintMapper.selectByExample(example);
    }

    public EtmallFootprint findById(Integer id) {
        return footprintMapper.selectByPrimaryKey(id);
    }

    public void deleteById(Integer id) {
        footprintMapper.logicalDeleteByPrimaryKey(id);
    }

    public void add(EtmallFootprint footprint) {
        footprint.setAddTime(LocalDateTime.now());
        footprint.setUpdateTime(LocalDateTime.now());
        footprintMapper.insertSelective(footprint);
    }

    public List<EtmallFootprint> querySelective(String userId, String goodsId, Integer page, Integer limit, String sort, String order) {
        EtmallFootprintExample example = new EtmallFootprintExample();
        EtmallFootprintExample.Criteria criteria = example.createCriteria();

        if (!StringUtils.isEmpty(userId)) {
            criteria.andUserIdEqualTo(Integer.valueOf(userId));
        }
        if (!StringUtils.isEmpty(goodsId)) {
            criteria.andGoodsIdEqualTo(Integer.valueOf(goodsId));
        }
        criteria.andDeletedEqualTo(false);

        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, limit);
        return footprintMapper.selectByExample(example);
    }
}
