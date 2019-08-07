package com.entanmo.etmall.db.service;

import com.entanmo.etmall.db.dao.EtmallBrandMapper;
import com.entanmo.etmall.db.domain.EtmallBrand;
import com.entanmo.etmall.db.domain.EtmallBrand.Column;
import com.entanmo.etmall.db.domain.EtmallBrandExample;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
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

    public EtmallBrand findById(Integer id) {
        return brandMapper.selectByPrimaryKey(id);
    }
}
