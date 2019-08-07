package com.entanmo.etmall.db.service;

import com.entanmo.etmall.db.dao.EtmallFeedbackMapper;
import com.entanmo.etmall.db.domain.EtmallFeedback;
import com.entanmo.etmall.db.domain.EtmallFeedbackExample;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class EtmallFeedbackService {

    @Resource
    private EtmallFeedbackMapper feedbackMapper;

    public Integer add(EtmallFeedback feedback) {
        feedback.setAddTime(LocalDateTime.now());
        feedback.setUpdateTime(LocalDateTime.now());
        return feedbackMapper.insertSelective(feedback);
    }

    public List<EtmallFeedback> querySelective(Integer userId, String username, Integer page, Integer limit, String sort, String order) {
        EtmallFeedbackExample example = new EtmallFeedbackExample();
        EtmallFeedbackExample.Criteria criteria = example.createCriteria();

        if (userId != null) {
            criteria.andUserIdEqualTo(userId);
        }
        if (!StringUtils.isEmpty(username)) {
            criteria.andUsernameLike("%" + username + "%");
        }
        criteria.andDeletedEqualTo(false);

        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, limit);
        return feedbackMapper.selectByExample(example);
    }
}
