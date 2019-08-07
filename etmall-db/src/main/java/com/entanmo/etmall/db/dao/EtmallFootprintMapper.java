package com.entanmo.etmall.db.dao;

import com.entanmo.etmall.db.domain.EtmallFootprint;
import com.entanmo.etmall.db.domain.EtmallFootprintExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EtmallFootprintMapper {
    long countByExample(EtmallFootprintExample example);

    int deleteByExample(EtmallFootprintExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EtmallFootprint record);

    int insertSelective(EtmallFootprint record);

    EtmallFootprint selectOneByExample(EtmallFootprintExample example);

    EtmallFootprint selectOneByExampleSelective(@Param("example") EtmallFootprintExample example, @Param("selective") EtmallFootprint.Column ... selective);

    List<EtmallFootprint> selectByExampleSelective(@Param("example") EtmallFootprintExample example, @Param("selective") EtmallFootprint.Column ... selective);

    List<EtmallFootprint> selectByExample(EtmallFootprintExample example);

    EtmallFootprint selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") EtmallFootprint.Column ... selective);

    EtmallFootprint selectByPrimaryKey(Integer id);

    EtmallFootprint selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") EtmallFootprint record, @Param("example") EtmallFootprintExample example);

    int updateByExample(@Param("record") EtmallFootprint record, @Param("example") EtmallFootprintExample example);

    int updateByPrimaryKeySelective(EtmallFootprint record);

    int updateByPrimaryKey(EtmallFootprint record);

    int logicalDeleteByExample(@Param("example") EtmallFootprintExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}