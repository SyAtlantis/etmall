package com.entanmo.etmall.db.service;

import com.entanmo.etmall.db.dao.EtmallBrandMapper;
import com.entanmo.etmall.db.domain.EtmallBrand;
import com.entanmo.etmall.db.domain.EtmallBrand.Column;
import com.entanmo.etmall.db.domain.EtmallBrandExample;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class EtmallBrandService {

    @Resource
    private EtmallBrandMapper brandMapper;

    private Column[] columns = new Column[]{Column.id, Column.name, Column.desc, Column.picUrl, Column.floorPrice};
    
    public List<EtmallBrand> query(Integer page, Integer limit, String sort, String order) {
        EtmallBrandExample example = new EtmallBrandExample();
        example.or().andDeletedEqualTo(false);
        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }
        PageHelper.startPage(page, limit);
        return brandMapper.selectByExampleSelective(example, columns);
    }

    public List<EtmallBrand> query(Integer page, Integer limit) {
        return query(page, limit, null, null);
    }

    public EtmallBrand findById(Integer id) {
        return brandMapper.selectByPrimaryKey(id);
    }

    public int updateById(EtmallBrand brand) {
        brand.setUpdateTime(LocalDateTime.now());
        return brandMapper.updateByPrimaryKeySelective(brand);
    }

    public void deleteById(Integer id) {
        brandMapper.logicalDeleteByPrimaryKey(id);
    }

    public void add(EtmallBrand brand) {
        brand.setAddTime(LocalDateTime.now());
        brand.setUpdateTime(LocalDateTime.now());
        brandMapper.insertSelective(brand);
    }

    public List<EtmallBrand> all() {
        EtmallBrandExample example = new EtmallBrandExample();
        example.or().andDeletedEqualTo(false);
        return brandMapper.selectByExample(example);
    }

    public List<EtmallBrand> querySelective(String id, String name, Integer page, Integer size, String sort, String order) {
        EtmallBrandExample example = new EtmallBrandExample();
        EtmallBrandExample.Criteria criteria = example.createCriteria();

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
        return brandMapper.selectByExample(example);
    }

}
