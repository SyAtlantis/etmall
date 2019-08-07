package com.entanmo.etmall.db.dao;

import com.entanmo.etmall.db.domain.EtmallAd;
import com.entanmo.etmall.db.domain.EtmallAdExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EtmallAdMapper {
    long countByExample(EtmallAdExample example);

    int deleteByExample(EtmallAdExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EtmallAd record);

    int insertSelective(EtmallAd record);

    EtmallAd selectOneByExample(EtmallAdExample example);

    EtmallAd selectOneByExampleSelective(@Param("example") EtmallAdExample example, @Param("selective") EtmallAd.Column ... selective);

    List<EtmallAd> selectByExampleSelective(@Param("example") EtmallAdExample example, @Param("selective") EtmallAd.Column ... selective);

    List<EtmallAd> selectByExample(EtmallAdExample example);

    EtmallAd selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") EtmallAd.Column ... selective);

    EtmallAd selectByPrimaryKey(Integer id);

    EtmallAd selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") EtmallAd record, @Param("example") EtmallAdExample example);

    int updateByExample(@Param("record") EtmallAd record, @Param("example") EtmallAdExample example);

    int updateByPrimaryKeySelective(EtmallAd record);

    int updateByPrimaryKey(EtmallAd record);

    int logicalDeleteByExample(@Param("example") EtmallAdExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}