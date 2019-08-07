package com.entanmo.etmall.db.dao;

import com.entanmo.etmall.db.domain.EtmallCollect;
import com.entanmo.etmall.db.domain.EtmallCollectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EtmallCollectMapper {
    long countByExample(EtmallCollectExample example);

    int deleteByExample(EtmallCollectExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EtmallCollect record);

    int insertSelective(EtmallCollect record);

    EtmallCollect selectOneByExample(EtmallCollectExample example);

    EtmallCollect selectOneByExampleSelective(@Param("example") EtmallCollectExample example, @Param("selective") EtmallCollect.Column ... selective);

    List<EtmallCollect> selectByExampleSelective(@Param("example") EtmallCollectExample example, @Param("selective") EtmallCollect.Column ... selective);

    List<EtmallCollect> selectByExample(EtmallCollectExample example);

    EtmallCollect selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") EtmallCollect.Column ... selective);

    EtmallCollect selectByPrimaryKey(Integer id);

    EtmallCollect selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") EtmallCollect record, @Param("example") EtmallCollectExample example);

    int updateByExample(@Param("record") EtmallCollect record, @Param("example") EtmallCollectExample example);

    int updateByPrimaryKeySelective(EtmallCollect record);

    int updateByPrimaryKey(EtmallCollect record);

    int logicalDeleteByExample(@Param("example") EtmallCollectExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}