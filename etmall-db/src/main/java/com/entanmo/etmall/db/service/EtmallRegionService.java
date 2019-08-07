package com.entanmo.etmall.db.service;

import com.entanmo.etmall.db.dao.EtmallRegionMapper;
import com.entanmo.etmall.db.domain.EtmallRegion;
import com.entanmo.etmall.db.domain.EtmallRegionExample;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EtmallRegionService {

    @Resource
    private EtmallRegionMapper regionMapper;

    public List<EtmallRegion> getAll(){
        EtmallRegionExample example = new EtmallRegionExample();
        byte b = 4;
        example.or().andTypeNotEqualTo(b);
        return regionMapper.selectByExample(example);
    }

    public List<EtmallRegion> queryByPid(Integer parentId) {
        EtmallRegionExample example = new EtmallRegionExample();
        example.or().andPidEqualTo(parentId);
        return regionMapper.selectByExample(example);
    }

    public EtmallRegion findById(Integer id) {
        return regionMapper.selectByPrimaryKey(id);
    }

    public List<EtmallRegion> querySelective(String name, Integer code, Integer page, Integer size, String sort, String order) {
        EtmallRegionExample example = new EtmallRegionExample();
        EtmallRegionExample.Criteria criteria = example.createCriteria();

        if (!StringUtils.isEmpty(name)) {
            criteria.andNameLike("%" + name + "%");
        }
        if (!StringUtils.isEmpty(code)) {
            criteria.andCodeEqualTo(code);
        }

        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, size);
        return regionMapper.selectByExample(example);
    }

}
