package com.entanmo.etmall.db.service;

import com.entanmo.etmall.db.dao.EtmallUserMapper;
import com.entanmo.etmall.db.domain.EtmallUser;
import com.entanmo.etmall.db.domain.EtmallUserExample;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class EtmallUserService {

    @Resource
    private EtmallUserMapper userMapper;

    public EtmallUser findById(Integer userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

//    public UserVo findUserVoById(Integer userId) {
//        EtmallUser user = findById(userId);
//        UserVo userVo = new UserVo();
//        userVo.setNickname(user.getNickname());
//        userVo.setAvatar(user.getAvatar());
//        return userVo;
//    }

    public EtmallUser queryByOid(String openId) {
        EtmallUserExample example = new EtmallUserExample();
        example.or().andOpenidEqualTo(openId).andDeletedEqualTo(false);
        return userMapper.selectOneByExample(example);
    }

    public void add(EtmallUser user) {
        user.setAddTime(LocalDateTime.now());
        user.setUpdateTime(LocalDateTime.now());
        userMapper.insertSelective(user);
    }

    public int updateById(EtmallUser user) {
        user.setUpdateTime(LocalDateTime.now());
        return userMapper.updateByPrimaryKeySelective(user);
    }

    public List<EtmallUser> querySelective(String username, String mobile, Integer page, Integer size, String sort, String order) {
        EtmallUserExample example = new EtmallUserExample();
        EtmallUserExample.Criteria criteria = example.createCriteria();

        if (!StringUtils.isEmpty(username)) {
            criteria.andUsernameLike("%" + username + "%");
        }
        if (!StringUtils.isEmpty(mobile)) {
            criteria.andMobileEqualTo(mobile);
        }
        criteria.andDeletedEqualTo(false);

        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, size);
        return userMapper.selectByExample(example);
    }

    public int count() {
        EtmallUserExample example = new EtmallUserExample();
        example.or().andDeletedEqualTo(false);

        return (int) userMapper.countByExample(example);
    }

    public List<EtmallUser> queryByUsername(String username) {
        EtmallUserExample example = new EtmallUserExample();
        example.or().andUsernameEqualTo(username).andDeletedEqualTo(false);
        return userMapper.selectByExample(example);
    }

    public boolean checkByUsername(String username) {
        EtmallUserExample example = new EtmallUserExample();
        example.or().andUsernameEqualTo(username).andDeletedEqualTo(false);
        return userMapper.countByExample(example) != 0;
    }

    public List<EtmallUser> queryByMobile(String mobile) {
        EtmallUserExample example = new EtmallUserExample();
        example.or().andMobileEqualTo(mobile).andDeletedEqualTo(false);
        return userMapper.selectByExample(example);
    }

    public List<EtmallUser> queryByOpenid(String openid) {
        EtmallUserExample example = new EtmallUserExample();
        example.or().andOpenidEqualTo(openid).andDeletedEqualTo(false);
        return userMapper.selectByExample(example);
    }

    public void deleteById(Integer id) {
        userMapper.logicalDeleteByPrimaryKey(id);
    }
}
