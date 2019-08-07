package com.entanmo.etmall.db.dao;

import com.entanmo.etmall.db.domain.EtmallLog;
import com.entanmo.etmall.db.domain.EtmallLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EtmallLogMapper {
    long countByExample(EtmallLogExample example);

    int deleteByExample(EtmallLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EtmallLog record);

    int insertSelective(EtmallLog record);

    EtmallLog selectOneByExample(EtmallLogExample example);

    EtmallLog selectOneByExampleSelective(@Param("example") EtmallLogExample example, @Param("selective") EtmallLog.Column ... selective);

    List<EtmallLog> selectByExampleSelective(@Param("example") EtmallLogExample example, @Param("selective") EtmallLog.Column ... selective);

    List<EtmallLog> selectByExample(EtmallLogExample example);

    EtmallLog selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") EtmallLog.Column ... selective);

    EtmallLog selectByPrimaryKey(Integer id);

    EtmallLog selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") EtmallLog record, @Param("example") EtmallLogExample example);

    int updateByExample(@Param("record") EtmallLog record, @Param("example") EtmallLogExample example);

    int updateByPrimaryKeySelective(EtmallLog record);

    int updateByPrimaryKey(EtmallLog record);

    int logicalDeleteByExample(@Param("example") EtmallLogExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}