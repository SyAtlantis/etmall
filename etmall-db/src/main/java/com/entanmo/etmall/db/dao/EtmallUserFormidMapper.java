package com.entanmo.etmall.db.dao;

import com.entanmo.etmall.db.domain.EtmallUserFormid;
import com.entanmo.etmall.db.domain.EtmallUserFormidExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EtmallUserFormidMapper {
    long countByExample(EtmallUserFormidExample example);

    int deleteByExample(EtmallUserFormidExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EtmallUserFormid record);

    int insertSelective(EtmallUserFormid record);

    EtmallUserFormid selectOneByExample(EtmallUserFormidExample example);

    EtmallUserFormid selectOneByExampleSelective(@Param("example") EtmallUserFormidExample example, @Param("selective") EtmallUserFormid.Column ... selective);

    List<EtmallUserFormid> selectByExampleSelective(@Param("example") EtmallUserFormidExample example, @Param("selective") EtmallUserFormid.Column ... selective);

    List<EtmallUserFormid> selectByExample(EtmallUserFormidExample example);

    EtmallUserFormid selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") EtmallUserFormid.Column ... selective);

    EtmallUserFormid selectByPrimaryKey(Integer id);

    EtmallUserFormid selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") EtmallUserFormid record, @Param("example") EtmallUserFormidExample example);

    int updateByExample(@Param("record") EtmallUserFormid record, @Param("example") EtmallUserFormidExample example);

    int updateByPrimaryKeySelective(EtmallUserFormid record);

    int updateByPrimaryKey(EtmallUserFormid record);

    int logicalDeleteByExample(@Param("example") EtmallUserFormidExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}