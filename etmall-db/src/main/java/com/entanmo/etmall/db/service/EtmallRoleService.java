package com.entanmo.etmall.db.service;

import com.alibaba.druid.util.StringUtils;
import com.entanmo.etmall.db.dao.EtmallRoleMapper;
import com.entanmo.etmall.db.domain.EtmallRole;
import com.entanmo.etmall.db.domain.EtmallRoleExample;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class EtmallRoleService {

    @Resource
    private EtmallRoleMapper roleMapper;


    public Set<String> queryByIds(Integer[] roleIds) {
        Set<String> roles = new HashSet<String>();
        if(roleIds.length == 0){
            return roles;
        }

        EtmallRoleExample example = new EtmallRoleExample();
        example.or().andIdIn(Arrays.asList(roleIds)).andEnabledEqualTo(true).andDeletedEqualTo(false);
        List<EtmallRole> roleList = roleMapper.selectByExample(example);

        for(EtmallRole role : roleList){
            roles.add(role.getName());
        }

        return roles;

    }

    public List<EtmallRole> querySelective(String name, Integer page, Integer limit, String sort, String order) {
        EtmallRoleExample example = new EtmallRoleExample();
        EtmallRoleExample.Criteria criteria = example.createCriteria();

        if (!StringUtils.isEmpty(name)) {
            criteria.andNameLike("%" + name + "%");
        }
        criteria.andDeletedEqualTo(false);

        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, limit);
        return roleMapper.selectByExample(example);
    }

    public EtmallRole findById(Integer id) {
        return roleMapper.selectByPrimaryKey(id);
    }

    public void add(EtmallRole role) {
        role.setAddTime(LocalDateTime.now());
        role.setUpdateTime(LocalDateTime.now());
        roleMapper.insertSelective(role);
    }

    public void deleteById(Integer id) {
        roleMapper.logicalDeleteByPrimaryKey(id);
    }

    public void updateById(EtmallRole role) {
        role.setUpdateTime(LocalDateTime.now());
        roleMapper.updateByPrimaryKeySelective(role);
    }

    public boolean checkExist(String name) {
        EtmallRoleExample example = new EtmallRoleExample();
        example.or().andNameEqualTo(name).andDeletedEqualTo(false);
        return roleMapper.countByExample(example) != 0;
    }

    public List<EtmallRole> queryAll() {
        EtmallRoleExample example = new EtmallRoleExample();
        example.or().andDeletedEqualTo(false);
        return roleMapper.selectByExample(example);
    }
}
