package com.entanmo.etmall.db.service;

import com.entanmo.etmall.db.dao.EtmallAdMapper;
import com.entanmo.etmall.db.domain.EtmallAd;
import com.entanmo.etmall.db.domain.EtmallAdExample;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class EtmallAdService {

    @Resource
    private EtmallAdMapper adMapper;

    public List<EtmallAd> queryIndex() {
        EtmallAdExample example = new EtmallAdExample();
        example.or().andPositionEqualTo((byte) 1).andDeletedEqualTo(false).andEnabledEqualTo(true);
        return adMapper.selectByExample(example);
    }

    public List<EtmallAd> querySelective(String name, String content, Integer page, Integer limit, String sort, String order) {
        EtmallAdExample example = new EtmallAdExample();
        EtmallAdExample.Criteria criteria = example.createCriteria();

        if (!StringUtils.isEmpty(name)) {
            criteria.andNameLike("%" + name + "%");
        }
        if (!StringUtils.isEmpty(content)) {
            criteria.andContentLike("%" + content + "%");
        }
        criteria.andDeletedEqualTo(false);

        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, limit);
        return adMapper.selectByExample(example);
    }

    public int updateById(EtmallAd ad) {
        ad.setUpdateTime(LocalDateTime.now());
        return adMapper.updateByPrimaryKeySelective(ad);
    }

    public void deleteById(Integer id) {
        adMapper.logicalDeleteByPrimaryKey(id);
    }

    public void add(EtmallAd ad) {
        ad.setAddTime(LocalDateTime.now());
        ad.setUpdateTime(LocalDateTime.now());
        adMapper.insertSelective(ad);
    }

    public EtmallAd findById(Integer id) {
        return adMapper.selectByPrimaryKey(id);
    }
}
