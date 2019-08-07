package com.entanmo.etmall.db.service;

import com.entanmo.etmall.db.dao.EtmallTopicMapper;
import com.entanmo.etmall.db.domain.EtmallTopic;
import com.entanmo.etmall.db.domain.EtmallTopic.Column;
import com.entanmo.etmall.db.domain.EtmallTopicExample;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class EtmallTopicService {

    @Resource
    private EtmallTopicMapper topicMapper;

    private Column[] columns = new Column[]{Column.id, Column.title, Column.subtitle, Column.price, Column.picUrl, Column.readCount};

    public List<EtmallTopic> queryList(int offset, int limit) {
        return queryList(offset, limit, "add_time", "desc");
    }

    public List<EtmallTopic> queryList(int offset, int limit, String sort, String order) {
        EtmallTopicExample example = new EtmallTopicExample();
        example.or().andDeletedEqualTo(false);
        example.setOrderByClause(sort + " " + order);
        PageHelper.startPage(offset, limit);
        return topicMapper.selectByExampleSelective(example, columns);
    }

    public int queryTotal() {
        EtmallTopicExample example = new EtmallTopicExample();
        example.or().andDeletedEqualTo(false);
        return (int) topicMapper.countByExample(example);
    }

    public EtmallTopic findById(Integer id) {
        EtmallTopicExample example = new EtmallTopicExample();
        example.or().andIdEqualTo(id).andDeletedEqualTo(false);
        return topicMapper.selectOneByExampleWithBLOBs(example);
    }

    public List<EtmallTopic> queryRelatedList(Integer id, int offset, int limit) {
        EtmallTopicExample example = new EtmallTopicExample();
        example.or().andIdEqualTo(id).andDeletedEqualTo(false);
        List<EtmallTopic> topics = topicMapper.selectByExample(example);
        if (topics.size() == 0) {
            return queryList(offset, limit, "add_time", "desc");
        }
        EtmallTopic topic = topics.get(0);

        example = new EtmallTopicExample();
        example.or().andIdNotEqualTo(topic.getId()).andDeletedEqualTo(false);
        PageHelper.startPage(offset, limit);
        List<EtmallTopic> relateds = topicMapper.selectByExampleWithBLOBs(example);
        if (relateds.size() != 0) {
            return relateds;
        }

        return queryList(offset, limit, "add_time", "desc");
    }

    public List<EtmallTopic> querySelective(String title, String subtitle, Integer page, Integer limit, String sort, String order) {
        EtmallTopicExample example = new EtmallTopicExample();
        EtmallTopicExample.Criteria criteria = example.createCriteria();

        if (!StringUtils.isEmpty(title)) {
            criteria.andTitleLike("%" + title + "%");
        }
        if (!StringUtils.isEmpty(subtitle)) {
            criteria.andSubtitleLike("%" + subtitle + "%");
        }
        criteria.andDeletedEqualTo(false);

        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, limit);
        return topicMapper.selectByExampleWithBLOBs(example);
    }

    public int updateById(EtmallTopic topic) {
        topic.setUpdateTime(LocalDateTime.now());
        EtmallTopicExample example = new EtmallTopicExample();
        example.or().andIdEqualTo(topic.getId());
        return topicMapper.updateByExampleSelective(topic, example);
    }

    public void deleteById(Integer id) {
        topicMapper.logicalDeleteByPrimaryKey(id);
    }

    public void add(EtmallTopic topic) {
        topic.setAddTime(LocalDateTime.now());
        topic.setUpdateTime(LocalDateTime.now());
        topicMapper.insertSelective(topic);
    }


}
