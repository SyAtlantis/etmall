package com.entanmo.etmall.db.service;


import com.entanmo.etmall.db.dao.EtmallUserFormidMapper;
import com.entanmo.etmall.db.domain.EtmallUserFormid;
import com.entanmo.etmall.db.domain.EtmallUserFormidExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;

@Service
public class EtmallUserFormIdService {

    @Resource
    private EtmallUserFormidMapper formidMapper;

    /**
     * 查找是否有可用的FormId
     */
    public EtmallUserFormid queryByOpenId(String openId) {
        EtmallUserFormidExample example = new EtmallUserFormidExample();
        //符合找到该用户记录，且可用次数大于1，且还未过期
        example.or().andOpenidEqualTo(openId).andExpireTimeGreaterThan(LocalDateTime.now());
        return formidMapper.selectOneByExample(example);
    }

    /**
     * 更新或删除FormId
     */
    public int updateUserFormId(EtmallUserFormid userFormid) {
        //更新或者删除缓存
        if (userFormid.getIsprepay() && userFormid.getUseamount() > 1) {
            userFormid.setUseamount(userFormid.getUseamount() - 1);
            userFormid.setUpdateTime(LocalDateTime.now());
            return formidMapper.updateByPrimaryKey(userFormid);
        } else {
            return formidMapper.deleteByPrimaryKey(userFormid.getId());
        }
    }

    /**
     * 添加一个 FormId
     */
    public void addUserFormid(EtmallUserFormid userFormid) {
        userFormid.setAddTime(LocalDateTime.now());
        userFormid.setUpdateTime(LocalDateTime.now());
        formidMapper.insertSelective(userFormid);
    }
}
