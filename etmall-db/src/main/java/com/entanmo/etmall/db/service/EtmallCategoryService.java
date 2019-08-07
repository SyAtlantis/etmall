package com.entanmo.etmall.db.service;

import com.entanmo.etmall.db.dao.EtmallCategoryMapper;
import com.entanmo.etmall.db.domain.EtmallCategory;
import com.entanmo.etmall.db.domain.EtmallCategory.Column;
import com.entanmo.etmall.db.domain.EtmallCategoryExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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

    public EtmallCategory findById(Integer id) {
        return categoryMapper.selectByPrimaryKey(id);
    }

    public List<EtmallCategory> queryByPid(Integer id) {
        EtmallCategoryExample example = new EtmallCategoryExample();
        example.or().andPidEqualTo(id).andDeletedEqualTo(false);
        return categoryMapper.selectByExample(example);
    }
}
