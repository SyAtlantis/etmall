package com.entanmo.etmall.core.service;

import com.entanmo.etmall.core.dao.IOrder;
import com.entanmo.etmall.db.domain.EtmallOrder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;

@Service
public class OrderService {

    @Resource
    private IOrder orderMapper;

    public int updateWithOptimisticLocker(EtmallOrder order) {
        LocalDateTime preUpdateTime = order.getUpdateTime();
        order.setUpdateTime(LocalDateTime.now());
        return orderMapper.updateWithOptimisticLocker(preUpdateTime, order);
    }
}
