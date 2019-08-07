package com.entanmo.etmall.db.dao;

import com.entanmo.etmall.db.domain.EtmallSystem;
import com.entanmo.etmall.db.domain.EtmallSystemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EtmallSystemMapper {
    long countByExample(EtmallSystemExample example);

    int deleteByExample(EtmallSystemExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EtmallSystem record);

    int insertSelective(EtmallSystem record);

    EtmallSystem selectOneByExample(EtmallSystemExample example);

    EtmallSystem selectOneByExampleSelective(@Param("example") EtmallSystemExample example, @Param("selective") EtmallSystem.Column ... selective);

    List<EtmallSystem> selectByExampleSelective(@Param("example") EtmallSystemExample example, @Param("selective") EtmallSystem.Column ... selective);

    List<EtmallSystem> selectByExample(EtmallSystemExample example);

    EtmallSystem selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") EtmallSystem.Column ... selective);

    EtmallSystem selectByPrimaryKey(Integer id);

    EtmallSystem selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") EtmallSystem record, @Param("example") EtmallSystemExample example);

    int updateByExample(@Param("record") EtmallSystem record, @Param("example") EtmallSystemExample example);

    int updateByPrimaryKeySelective(EtmallSystem record);

    int updateByPrimaryKey(EtmallSystem record);

    int logicalDeleteByExample(@Param("example") EtmallSystemExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}