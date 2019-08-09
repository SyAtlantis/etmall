package com.entanmo.etmall.core.service;

import com.entanmo.etmall.core.vo.GrouponRuleVo;
import com.entanmo.etmall.db.domain.EtmallGoods;
import com.entanmo.etmall.db.domain.EtmallGrouponRules;
import com.entanmo.etmall.db.service.EtmallGoodsService;
import com.entanmo.etmall.db.service.EtmallGrouponRulesService;
import com.entanmo.etmall.db.service.EtmallGrouponService;
import com.github.pagehelper.Page;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserGrouponRuleService {
//    private final Log logger = LogFactory.getLog(UserGrouponRuleService.class);

//    @Autowired
    private EtmallGrouponRulesService grouponRulesService;
//    @Autowired
    private EtmallGrouponService grouponService;
//    @Autowired
    private EtmallGoodsService goodsService;


    public List<GrouponRuleVo> queryList(Integer page, Integer size) {
        return queryList(page, size, "add_time", "desc");
    }


    public List<GrouponRuleVo> queryList(Integer page, Integer size, String sort, String order) {
        Page<EtmallGrouponRules> grouponRulesList = (Page)grouponRulesService.queryList(page, size, sort, order);

        Page<GrouponRuleVo> grouponList = new Page<GrouponRuleVo>();
        grouponList.setPages(grouponRulesList.getPages());
        grouponList.setPageNum(grouponRulesList.getPageNum());
        grouponList.setPageSize(grouponRulesList.getPageSize());
        grouponList.setTotal(grouponRulesList.getTotal());

        for (EtmallGrouponRules rule : grouponRulesList) {
            Integer goodsId = rule.getGoodsId();
            EtmallGoods goods = goodsService.findById(goodsId);
            if (goods == null)
                continue;

            GrouponRuleVo grouponRuleVo = new GrouponRuleVo();
            grouponRuleVo.setId(goods.getId());
            grouponRuleVo.setName(goods.getName());
            grouponRuleVo.setBrief(goods.getBrief());
            grouponRuleVo.setPicUrl(goods.getPicUrl());
            grouponRuleVo.setCounterPrice(goods.getCounterPrice());
            grouponRuleVo.setRetailPrice(goods.getRetailPrice());
            grouponRuleVo.setGrouponPrice(goods.getRetailPrice().subtract(rule.getDiscount()));
            grouponRuleVo.setGrouponDiscount(rule.getDiscount());
            grouponRuleVo.setGrouponMember(rule.getDiscountMember());
            grouponList.add(grouponRuleVo);
        }

        return grouponList;
    }
}