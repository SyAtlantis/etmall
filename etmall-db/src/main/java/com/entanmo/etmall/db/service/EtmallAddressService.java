package com.entanmo.etmall.db.service;

import com.entanmo.etmall.db.dao.EtmallAddressMapper;
import com.entanmo.etmall.db.domain.EtmallAddress;
import com.entanmo.etmall.db.domain.EtmallAddressExample;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class EtmallAddressService {

    @Resource
    private EtmallAddressMapper addressMapper;

    public List<EtmallAddress> queryByUid(Integer userId) {
        EtmallAddressExample example = new EtmallAddressExample();
        example.or().andUserIdEqualTo(userId).andDeletedEqualTo(false);
        return addressMapper.selectByExample(example);
    }

    public EtmallAddress query(Integer userId, Integer id) {
        EtmallAddressExample example = new EtmallAddressExample();
        example.or().andIdEqualTo(id).andUserIdEqualTo(userId).andDeletedEqualTo(false);
        return addressMapper.selectOneByExample(example);
    }

    public void resetDefault(Integer userId) {
        EtmallAddress address = new EtmallAddress();
        address.setIsDefault(false);
        address.setUpdateTime(LocalDateTime.now());
        EtmallAddressExample example = new EtmallAddressExample();
        example.or().andUserIdEqualTo(userId).andDeletedEqualTo(false);
        addressMapper.updateByExampleSelective(address, example);
    }

    public EtmallAddress findDefault(Integer userId) {
        EtmallAddressExample example = new EtmallAddressExample();
        example.or().andUserIdEqualTo(userId).andIsDefaultEqualTo(true).andDeletedEqualTo(false);
        return addressMapper.selectOneByExample(example);
    }

    public int add(EtmallAddress address) {
        address.setAddTime(LocalDateTime.now());
        address.setUpdateTime(LocalDateTime.now());
        return addressMapper.insertSelective(address);
    }

    public int update(EtmallAddress address) {
        address.setUpdateTime(LocalDateTime.now());
        return addressMapper.updateByPrimaryKeySelective(address);
    }

    public void delete(Integer id) {
        addressMapper.logicalDeleteByPrimaryKey(id);
    }

    public List<EtmallAddress> querySelective(Integer userId, String name, Integer page, Integer limit, String sort, String order) {
        EtmallAddressExample example = new EtmallAddressExample();
        EtmallAddressExample.Criteria criteria = example.createCriteria();

        if (userId != null) {
            criteria.andUserIdEqualTo(userId);
        }
        if (!StringUtils.isEmpty(name)) {
            criteria.andNameLike("%" + name + "%");
        }
        criteria.andDeletedEqualTo(false);

        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, limit);
        return addressMapper.selectByExample(example);
    }
}
