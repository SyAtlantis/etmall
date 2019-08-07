package com.entanmo.etmall.db.dao;

import com.entanmo.etmall.db.domain.EtmallUser;
import com.entanmo.etmall.db.domain.EtmallUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EtmallUserMapper {
    long countByExample(EtmallUserExample example);

    int deleteByExample(EtmallUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EtmallUser record);

    int insertSelective(EtmallUser record);

    EtmallUser selectOneByExample(EtmallUserExample example);

    EtmallUser selectOneByExampleSelective(@Param("example") EtmallUserExample example, @Param("selective") EtmallUser.Column ... selective);

    List<EtmallUser> selectByExampleSelective(@Param("example") EtmallUserExample example, @Param("selective") EtmallUser.Column ... selective);

    List<EtmallUser> selectByExample(EtmallUserExample example);

    EtmallUser selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") EtmallUser.Column ... selective);

    EtmallUser selectByPrimaryKey(Integer id);

    EtmallUser selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") EtmallUser record, @Param("example") EtmallUserExample example);

    int updateByExample(@Param("record") EtmallUser record, @Param("example") EtmallUserExample example);

    int updateByPrimaryKeySelective(EtmallUser record);

    int updateByPrimaryKey(EtmallUser record);

    int logicalDeleteByExample(@Param("example") EtmallUserExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}