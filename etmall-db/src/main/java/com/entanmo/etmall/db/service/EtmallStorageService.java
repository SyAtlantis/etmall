package com.entanmo.etmall.db.service;

import com.entanmo.etmall.db.dao.EtmallStorageMapper;
import com.entanmo.etmall.db.domain.EtmallStorage;
import com.entanmo.etmall.db.domain.EtmallStorageExample;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class EtmallStorageService {

    @Resource
    private EtmallStorageMapper storageMapper;

    public void deleteByKey(String key) {
        EtmallStorageExample example = new EtmallStorageExample();
        example.or().andKeyEqualTo(key);
        storageMapper.logicalDeleteByExample(example);
    }

    public void add(EtmallStorage storageInfo) {
        storageInfo.setAddTime(LocalDateTime.now());
        storageInfo.setUpdateTime(LocalDateTime.now());
        storageMapper.insertSelective(storageInfo);
    }

    public EtmallStorage findByKey(String key) {
        EtmallStorageExample example = new EtmallStorageExample();
        example.or().andKeyEqualTo(key).andDeletedEqualTo(false);
        return storageMapper.selectOneByExample(example);
    }

    public int update(EtmallStorage storageInfo) {
        storageInfo.setUpdateTime(LocalDateTime.now());
        return storageMapper.updateByPrimaryKeySelective(storageInfo);
    }

    public EtmallStorage findById(Integer id) {
        return storageMapper.selectByPrimaryKey(id);
    }

    public List<EtmallStorage> querySelective(String key, String name, Integer page, Integer limit, String sort, String order) {
        EtmallStorageExample example = new EtmallStorageExample();
        EtmallStorageExample.Criteria criteria = example.createCriteria();

        if (!StringUtils.isEmpty(key)) {
            criteria.andKeyEqualTo(key);
        }
        if (!StringUtils.isEmpty(name)) {
            criteria.andNameLike("%" + name + "%");
        }
        criteria.andDeletedEqualTo(false);

        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, limit);
        return storageMapper.selectByExample(example);
    }
}
