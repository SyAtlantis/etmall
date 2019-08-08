package com.entanmo.etmall.db.service;

import com.entanmo.etmall.db.dao.EtmallCategoryMapper;
import com.entanmo.etmall.db.domain.EtmallCategory;
import com.entanmo.etmall.db.domain.EtmallCategory.Column;
import com.entanmo.etmall.db.domain.EtmallCategoryExample;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class EtmallCategoryService {

    @Resource
    private EtmallCategoryMapper categoryMapper;
    
    private Column[] CHANNEL = {Column.id, Column.name, Column.iconUrl};
    
    public List<EtmallCategory> queryL1() {
        EtmallCategoryExample example = new EtmallCategoryExample();
        example.or().andLevelEqualTo("L1").andDeletedEqualTo(false);
        return categoryMapper.selectByExample(example);
    }

    public List<EtmallCategory> queryL1(int offset, int limit) {
        EtmallCategoryExample example = new EtmallCategoryExample();
        example.or().andLevelEqualTo("L1").andDeletedEqualTo(false);
        PageHelper.startPage(offset, limit);
        return categoryMapper.selectByExample(example);
    }

    public List<EtmallCategory> queryL1WithoutRecommend(int offset, int limit) {
        EtmallCategoryExample example = new EtmallCategoryExample();
        example.or().andLevelEqualTo("L1").andNameNotEqualTo("推荐").andDeletedEqualTo(false);
        PageHelper.startPage(offset, limit);
        return categoryMapper.selectByExample(example);
    }

    public List<EtmallCategory> queryByPid(Integer pid) {
        EtmallCategoryExample example = new EtmallCategoryExample();
        example.or().andPidEqualTo(pid).andDeletedEqualTo(false);
        return categoryMapper.selectByExample(example);
    }

    public List<EtmallCategory> queryL2ByIds(List<Integer> ids) {
        EtmallCategoryExample example = new EtmallCategoryExample();
        example.or().andIdIn(ids).andLevelEqualTo("L2").andDeletedEqualTo(false);
        return categoryMapper.selectByExample(example);
    }

    public EtmallCategory findById(Integer id) {
        return categoryMapper.selectByPrimaryKey(id);
    }

    public List<EtmallCategory> querySelective(String id, String name, Integer page, Integer size, String sort, String order) {
        EtmallCategoryExample example = new EtmallCategoryExample();
        EtmallCategoryExample.Criteria criteria = example.createCriteria();

        if (!StringUtils.isEmpty(id)) {
            criteria.andIdEqualTo(Integer.valueOf(id));
        }
        if (!StringUtils.isEmpty(name)) {
            criteria.andNameLike("%" + name + "%");
        }
        criteria.andDeletedEqualTo(false);

        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, size);
        return categoryMapper.selectByExample(example);
    }

    public int updateById(EtmallCategory category) {
        category.setUpdateTime(LocalDateTime.now());
        return categoryMapper.updateByPrimaryKeySelective(category);
    }

    public void deleteById(Integer id) {
        categoryMapper.logicalDeleteByPrimaryKey(id);
    }

    public void add(EtmallCategory category) {
        category.setAddTime(LocalDateTime.now());
        category.setUpdateTime(LocalDateTime.now());
        categoryMapper.insertSelective(category);
    }

    public List<EtmallCategory> queryChannel() {
        EtmallCategoryExample example = new EtmallCategoryExample();
        example.or().andLevelEqualTo("L1").andDeletedEqualTo(false);
        return categoryMapper.selectByExampleSelective(example, CHANNEL);
    }
}
