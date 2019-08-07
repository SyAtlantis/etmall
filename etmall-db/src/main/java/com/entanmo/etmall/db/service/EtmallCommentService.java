package com.entanmo.etmall.db.service;

import com.entanmo.etmall.db.dao.EtmallCommentMapper;
import com.entanmo.etmall.db.domain.EtmallComment;
import com.entanmo.etmall.db.domain.EtmallCommentExample;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class EtmallCommentService {

    @Resource
    private EtmallCommentMapper commentMapper;

    public List<EtmallComment> queryGoodsByGid(Integer id, int offset, int limit) {
        EtmallCommentExample example = new EtmallCommentExample();
        example.setOrderByClause(EtmallComment.Column.addTime.desc());
        example.or().andValueIdEqualTo(id).andTypeEqualTo((byte) 0).andDeletedEqualTo(false);
        PageHelper.startPage(offset, limit);
        return commentMapper.selectByExample(example);
    }

    public List<EtmallComment> query(Byte type, Integer valueId, Integer showType, Integer offset, Integer limit) {
        EtmallCommentExample example = new EtmallCommentExample();
        example.setOrderByClause(EtmallComment.Column.addTime.desc());
        if (showType == 0) {
            example.or().andValueIdEqualTo(valueId).andTypeEqualTo(type).andDeletedEqualTo(false);
        } else if (showType == 1) {
            example.or().andValueIdEqualTo(valueId).andTypeEqualTo(type).andHasPictureEqualTo(true).andDeletedEqualTo(false);
        } else {
            throw new RuntimeException("showType不支持");
        }
        PageHelper.startPage(offset, limit);
        return commentMapper.selectByExample(example);
    }

    public int count(Byte type, Integer valueId, Integer showType) {
        EtmallCommentExample example = new EtmallCommentExample();
        if (showType == 0) {
            example.or().andValueIdEqualTo(valueId).andTypeEqualTo(type).andDeletedEqualTo(false);
        } else if (showType == 1) {
            example.or().andValueIdEqualTo(valueId).andTypeEqualTo(type).andHasPictureEqualTo(true).andDeletedEqualTo(false);
        } else {
            throw new RuntimeException("showType不支持");
        }
        return (int) commentMapper.countByExample(example);
    }

    public int save(EtmallComment comment) {
        comment.setAddTime(LocalDateTime.now());
        comment.setUpdateTime(LocalDateTime.now());
        return commentMapper.insertSelective(comment);
    }

    public List<EtmallComment> querySelective(String userId, String valueId, Integer page, Integer size, String sort, String order) {
        EtmallCommentExample example = new EtmallCommentExample();
        EtmallCommentExample.Criteria criteria = example.createCriteria();

        // type=2 是订单商品回复，这里过滤
        criteria.andTypeNotEqualTo((byte) 2);

        if (!StringUtils.isEmpty(userId)) {
            criteria.andUserIdEqualTo(Integer.valueOf(userId));
        }
        if (!StringUtils.isEmpty(valueId)) {
            criteria.andValueIdEqualTo(Integer.valueOf(valueId)).andTypeEqualTo((byte) 0);
        }
        criteria.andDeletedEqualTo(false);

        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, size);
        return commentMapper.selectByExample(example);
    }

    public void deleteById(Integer id) {
        commentMapper.logicalDeleteByPrimaryKey(id);
    }

    public String queryReply(Integer id) {
        EtmallCommentExample example = new EtmallCommentExample();
        example.or().andTypeEqualTo((byte) 2).andValueIdEqualTo(id);
        List<EtmallComment> commentReply = commentMapper.selectByExampleSelective(example, EtmallComment.Column.content);
        // 目前业务只支持回复一次
        if (commentReply.size() == 1) {
            return commentReply.get(0).getContent();
        }
        return null;
    }

    public EtmallComment findById(Integer id) {
        return commentMapper.selectByPrimaryKey(id);
    }
}
