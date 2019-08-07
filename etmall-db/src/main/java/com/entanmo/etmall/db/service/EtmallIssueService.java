package com.entanmo.etmall.db.service;

import com.entanmo.etmall.db.dao.EtmallIssueMapper;
import com.entanmo.etmall.db.domain.EtmallIssue;
import com.entanmo.etmall.db.domain.EtmallIssueExample;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EtmallIssueService {
    @Resource
    private EtmallIssueMapper issueMapper;
    
    public List<EtmallIssue> querySelective(String question, Integer page, Integer limit, String sort, String order) {
        EtmallIssueExample example = new EtmallIssueExample();
        EtmallIssueExample.Criteria criteria = example.createCriteria();

        if (!StringUtils.isEmpty(question)) {
            criteria.andQuestionLike("%" + question + "%");
        }
        criteria.andDeletedEqualTo(false);

        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, limit);
        return issueMapper.selectByExample(example);
    }
}
