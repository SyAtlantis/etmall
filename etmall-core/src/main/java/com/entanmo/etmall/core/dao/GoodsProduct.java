package com.entanmo.etmall.core.dao;

import org.apache.ibatis.annotations.Param;

public interface GoodsProduct {
    int addStock(@Param("id") Integer id, @Param("num") Short num);
    int reduceStock(@Param("id") Integer id, @Param("num") Short num);
}