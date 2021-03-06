package com.entanmo.etmall.db.service;

import com.alibaba.druid.util.StringUtils;
import com.entanmo.etmall.db.dao.EtmallGrouponRulesMapper;
import com.entanmo.etmall.db.domain.EtmallGrouponRules;
import com.entanmo.etmall.db.domain.EtmallGrouponRulesExample;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class EtmallGrouponRulesService {

    @Resource
    private EtmallGrouponRulesMapper mapper;

    public int createRules(EtmallGrouponRules rules) {
        rules.setAddTime(LocalDateTime.now());
        rules.setUpdateTime(LocalDateTime.now());
        return mapper.insertSelective(rules);
    }

    /**
     * 根据ID查找对应团购项
     */
    public EtmallGrouponRules queryById(Integer id) {
        EtmallGrouponRulesExample example = new EtmallGrouponRulesExample();
        example.or().andIdEqualTo(id).andDeletedEqualTo(false);
        return mapper.selectOneByExample(example);
    }

    /**
     * 查询某个商品关联的团购规则
     */
    public List<EtmallGrouponRules> queryByGoodsId(Integer goodsId) {
        EtmallGrouponRulesExample example = new EtmallGrouponRulesExample();
        example.or().andGoodsIdEqualTo(goodsId).andDeletedEqualTo(false);
        return mapper.selectByExample(example);
    }

    /**
     * 获取首页团购活动列表
     */
    public List<EtmallGrouponRules> queryList(Integer page, Integer limit) {
        return queryList(page, limit, "add_time", "desc");
    }

    public List<EtmallGrouponRules> queryList(Integer page, Integer limit, String sort, String order) {
        EtmallGrouponRulesExample example = new EtmallGrouponRulesExample();
        example.or().andDeletedEqualTo(false);
        example.setOrderByClause(sort + " " + order);
        PageHelper.startPage(page, limit);
        return mapper.selectByExample(example);
    }

    /**
     * 判断某个团购活动是否已经过期
     */
    public boolean isExpired(EtmallGrouponRules rules) {
        return (rules == null || rules.getExpireTime().isBefore(LocalDateTime.now()));
    }

    /**
     * 获取团购活动列表
     */
    public List<EtmallGrouponRules> querySelective(String goodsId, Integer page, Integer size, String sort, String order) {
        EtmallGrouponRulesExample example = new EtmallGrouponRulesExample();
        example.setOrderByClause(sort + " " + order);

        EtmallGrouponRulesExample.Criteria criteria = example.createCriteria();

        if (!StringUtils.isEmpty(goodsId)) {
            criteria.andGoodsIdEqualTo(Integer.parseInt(goodsId));
        }
        criteria.andDeletedEqualTo(false);

        PageHelper.startPage(page, size);
        return mapper.selectByExample(example);
    }

    public void delete(Integer id) {
        mapper.logicalDeleteByPrimaryKey(id);
    }

    public int updateById(EtmallGrouponRules grouponRules) {
        grouponRules.setUpdateTime(LocalDateTime.now());
        return mapper.updateByPrimaryKeySelective(grouponRules);
    }
}