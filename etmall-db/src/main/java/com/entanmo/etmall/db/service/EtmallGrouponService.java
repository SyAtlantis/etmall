package com.entanmo.etmall.db.service;

import com.alibaba.druid.util.StringUtils;
import com.entanmo.etmall.db.dao.EtmallGrouponMapper;
import com.entanmo.etmall.db.domain.EtmallGroupon;
import com.entanmo.etmall.db.domain.EtmallGrouponExample;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class EtmallGrouponService {

    @Resource
    private EtmallGrouponMapper mapper;

    /**
     * 获取用户发起的团购记录
     */
    public List<EtmallGroupon> queryMyGroupon(Integer userId) {
        EtmallGrouponExample example = new EtmallGrouponExample();
        example.or().andUserIdEqualTo(userId).andCreatorUserIdEqualTo(userId).andGrouponIdEqualTo(0).andDeletedEqualTo(false).andPayedEqualTo(true);
        example.orderBy("add_time desc");
        return mapper.selectByExample(example);
    }

    /**
     * 获取用户参与的团购记录
     */
    public List<EtmallGroupon> queryMyJoinGroupon(Integer userId) {
        EtmallGrouponExample example = new EtmallGrouponExample();
        example.or().andUserIdEqualTo(userId).andGrouponIdNotEqualTo(0).andDeletedEqualTo(false).andPayedEqualTo(true);
        example.orderBy("add_time desc");
        return mapper.selectByExample(example);
    }

    /**
     * 根据OrderId查询团购记录
     */
    public EtmallGroupon queryByOrderId(Integer orderId) {
        EtmallGrouponExample example = new EtmallGrouponExample();
        example.or().andOrderIdEqualTo(orderId).andDeletedEqualTo(false);
        return mapper.selectOneByExample(example);
    }

    /**
     * 获取某个团购活动参与的记录
     */
    public List<EtmallGroupon> queryJoinRecord(Integer id) {
        EtmallGrouponExample example = new EtmallGrouponExample();
        example.or().andGrouponIdEqualTo(id).andDeletedEqualTo(false).andPayedEqualTo(true);
        example.orderBy("add_time desc");
        return mapper.selectByExample(example);
    }

    /**
     * 根据ID查询记录
     */
    public EtmallGroupon queryById(Integer id) {
        EtmallGrouponExample example = new EtmallGrouponExample();
        example.or().andIdEqualTo(id).andDeletedEqualTo(false).andPayedEqualTo(true);
        return mapper.selectOneByExample(example);
    }

    /**
     * 返回某个发起的团购参与人数
     */
    public int countGroupon(Integer grouponId) {
        EtmallGrouponExample example = new EtmallGrouponExample();
        example.or().andGrouponIdEqualTo(grouponId).andDeletedEqualTo(false).andPayedEqualTo(true);
        return (int) mapper.countByExample(example);
    }

    public int updateById(EtmallGroupon groupon) {
        groupon.setUpdateTime(LocalDateTime.now());
        return mapper.updateByPrimaryKeySelective(groupon);
    }

    /**
     * 创建或参与一个团购
     */
    public int createGroupon(EtmallGroupon groupon) {
        groupon.setAddTime(LocalDateTime.now());
        groupon.setUpdateTime(LocalDateTime.now());
        return mapper.insertSelective(groupon);
    }


    /**
     * 查询所有发起的团购记录
     */
    public List<EtmallGroupon> querySelective(String rulesId, Integer page, Integer size, String sort, String order) {
        EtmallGrouponExample example = new EtmallGrouponExample();
        EtmallGrouponExample.Criteria criteria = example.createCriteria();

        if (!StringUtils.isEmpty(rulesId)) {
            criteria.andRulesIdEqualTo(Integer.parseInt(rulesId));
        }
        criteria.andDeletedEqualTo(false);
        criteria.andPayedEqualTo(true);
        criteria.andGrouponIdEqualTo(0);

        PageHelper.startPage(page, size);
        return mapper.selectByExample(example);
    }
}
