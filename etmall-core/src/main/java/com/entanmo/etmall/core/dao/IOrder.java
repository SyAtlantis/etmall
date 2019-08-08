package com.entanmo.etmall.core.dao;

import com.entanmo.etmall.db.domain.EtmallOrder;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;

public interface IOrder {
    int updateWithOptimisticLocker(@Param("lastUpdateTime") LocalDateTime lastUpdateTime, @Param("order") EtmallOrder order);
}