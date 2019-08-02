package com.entanmo.etmall.db.service;

import com.entanmo.etmall.db.dao.IAddressMapper;
import com.entanmo.etmall.db.domain.EtmallAddress;
import com.entanmo.etmall.db.domain.EtmallAddressExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EtmallAddressService {

    @Resource
    private IAddressMapper addressMapper;

    public List<EtmallAddress> queryByUid(Integer userId) {
//        EtmallAddressExample example = new EtmallAddressExample();
//        example.or().andUserIdEqualTo(userId).andDeletedEqualTo(false);
//        return addressMapper.selectByExample(example);
        return null;
    }

    public EtmallAddress query(Integer userId, Integer id) {
        return null;
    }

    public void resetDefault(Integer userId) {
    }

    public void add(EtmallAddress address) {
    }

    public void delete(Integer id) {
    }

    public int update(EtmallAddress address) {
        return 0;
    }

    public List<EtmallAddress> querySelective(Integer userId, String name, Integer page, Integer limit, String sort, String order) {
        return null;
    }
}
