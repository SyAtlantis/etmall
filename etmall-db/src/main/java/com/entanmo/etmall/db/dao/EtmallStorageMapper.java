package com.entanmo.etmall.db.dao;

import com.entanmo.etmall.db.domain.EtmallStorage;
import com.entanmo.etmall.db.domain.EtmallStorageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EtmallStorageMapper {
    long countByExample(EtmallStorageExample example);

    int deleteByExample(EtmallStorageExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EtmallStorage record);

    int insertSelective(EtmallStorage record);

    EtmallStorage selectOneByExample(EtmallStorageExample example);

    EtmallStorage selectOneByExampleSelective(@Param("example") EtmallStorageExample example, @Param("selective") EtmallStorage.Column ... selective);

    List<EtmallStorage> selectByExampleSelective(@Param("example") EtmallStorageExample example, @Param("selective") EtmallStorage.Column ... selective);

    List<EtmallStorage> selectByExample(EtmallStorageExample example);

    EtmallStorage selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") EtmallStorage.Column ... selective);

    EtmallStorage selectByPrimaryKey(Integer id);

    EtmallStorage selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") EtmallStorage record, @Param("example") EtmallStorageExample example);

    int updateByExample(@Param("record") EtmallStorage record, @Param("example") EtmallStorageExample example);

    int updateByPrimaryKeySelective(EtmallStorage record);

    int updateByPrimaryKey(EtmallStorage record);

    int logicalDeleteByExample(@Param("example") EtmallStorageExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}