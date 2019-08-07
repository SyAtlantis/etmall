package com.entanmo.etmall.db.dao;

import com.entanmo.etmall.db.domain.EtmallCoupon;
import com.entanmo.etmall.db.domain.EtmallCouponExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EtmallCouponMapper {
    long countByExample(EtmallCouponExample example);

    int deleteByExample(EtmallCouponExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EtmallCoupon record);

    int insertSelective(EtmallCoupon record);

    EtmallCoupon selectOneByExample(EtmallCouponExample example);

    EtmallCoupon selectOneByExampleSelective(@Param("example") EtmallCouponExample example, @Param("selective") EtmallCoupon.Column ... selective);

    List<EtmallCoupon> selectByExampleSelective(@Param("example") EtmallCouponExample example, @Param("selective") EtmallCoupon.Column ... selective);

    List<EtmallCoupon> selectByExample(EtmallCouponExample example);

    EtmallCoupon selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") EtmallCoupon.Column ... selective);

    EtmallCoupon selectByPrimaryKey(Integer id);

    EtmallCoupon selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") EtmallCoupon record, @Param("example") EtmallCouponExample example);

    int updateByExample(@Param("record") EtmallCoupon record, @Param("example") EtmallCouponExample example);

    int updateByPrimaryKeySelective(EtmallCoupon record);

    int updateByPrimaryKey(EtmallCoupon record);

    int logicalDeleteByExample(@Param("example") EtmallCouponExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}