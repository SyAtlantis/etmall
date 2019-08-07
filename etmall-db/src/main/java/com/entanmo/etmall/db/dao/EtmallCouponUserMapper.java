package com.entanmo.etmall.db.dao;

import com.entanmo.etmall.db.domain.EtmallCouponUser;
import com.entanmo.etmall.db.domain.EtmallCouponUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EtmallCouponUserMapper {
    long countByExample(EtmallCouponUserExample example);

    int deleteByExample(EtmallCouponUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EtmallCouponUser record);

    int insertSelective(EtmallCouponUser record);

    EtmallCouponUser selectOneByExample(EtmallCouponUserExample example);

    EtmallCouponUser selectOneByExampleSelective(@Param("example") EtmallCouponUserExample example, @Param("selective") EtmallCouponUser.Column ... selective);

    List<EtmallCouponUser> selectByExampleSelective(@Param("example") EtmallCouponUserExample example, @Param("selective") EtmallCouponUser.Column ... selective);

    List<EtmallCouponUser> selectByExample(EtmallCouponUserExample example);

    EtmallCouponUser selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") EtmallCouponUser.Column ... selective);

    EtmallCouponUser selectByPrimaryKey(Integer id);

    EtmallCouponUser selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") EtmallCouponUser record, @Param("example") EtmallCouponUserExample example);

    int updateByExample(@Param("record") EtmallCouponUser record, @Param("example") EtmallCouponUserExample example);

    int updateByPrimaryKeySelective(EtmallCouponUser record);

    int updateByPrimaryKey(EtmallCouponUser record);

    int logicalDeleteByExample(@Param("example") EtmallCouponUserExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}