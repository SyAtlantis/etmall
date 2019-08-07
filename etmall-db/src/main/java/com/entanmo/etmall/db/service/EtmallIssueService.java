package com.entanmo.etmall.db.service;

import com.entanmo.etmall.db.dao.EtmallIssueMapper;
import com.entanmo.etmall.db.domain.EtmallIssue;
import com.entanmo.etmall.db.domain.EtmallIssueExample;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class EtmallIssueService {

    @Resource
    private EtmallIssueMapper issueMapper;

    public void deleteById(Integer id) {
        issueMapper.logicalDeleteByPrimaryKey(id);
    }

    public void add(EtmallIssue issue) {
        issue.setAddTime(LocalDateTime.now());
        issue.setUpdateTime(LocalDateTime.now());
        issueMapper.insertSelective(issue);
    }

    public int updateById(EtmallIssue issue) {
        issue.setUpdateTime(LocalDateTime.now());
        return issueMapper.updateByPrimaryKeySelective(issue);
    }

    public EtmallIssue findById(Integer id) {
        return issueMapper.selectByPrimaryKey(id);
    }
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
