package com.entanmo.etmall.db.service;

import com.entanmo.etmall.db.dao.EtmallSearchHistoryMapper;
import com.entanmo.etmall.db.domain.EtmallSearchHistory;
import com.entanmo.etmall.db.domain.EtmallSearchHistoryExample;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class EtmallSearchHistoryService {

    @Resource
    private EtmallSearchHistoryMapper searchHistoryMapper;

    public void save(EtmallSearchHistory searchHistory) {
        searchHistory.setAddTime(LocalDateTime.now());
        searchHistory.setUpdateTime(LocalDateTime.now());
        searchHistoryMapper.insertSelective(searchHistory);
    }

    public List<EtmallSearchHistory> queryByUid(int uid) {
        EtmallSearchHistoryExample example = new EtmallSearchHistoryExample();
        example.or().andUserIdEqualTo(uid).andDeletedEqualTo(false);
        example.setDistinct(true);
        return searchHistoryMapper.selectByExampleSelective(example, EtmallSearchHistory.Column.keyword);
    }

    public void deleteByUid(int uid) {
        EtmallSearchHistoryExample example = new EtmallSearchHistoryExample();
        example.or().andUserIdEqualTo(uid);
        searchHistoryMapper.logicalDeleteByExample(example);
    }

    public List<EtmallSearchHistory> querySelective(String userId, String keyword, Integer page, Integer size, String sort, String order) {
        EtmallSearchHistoryExample example = new EtmallSearchHistoryExample();
        EtmallSearchHistoryExample.Criteria criteria = example.createCriteria();

        if (!StringUtils.isEmpty(userId)) {
            criteria.andUserIdEqualTo(Integer.valueOf(userId));
        }
        if (!StringUtils.isEmpty(keyword)) {
            criteria.andKeywordLike("%" + keyword + "%");
        }
        criteria.andDeletedEqualTo(false);

        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, size);
        return searchHistoryMapper.selectByExample(example);
    }
}
