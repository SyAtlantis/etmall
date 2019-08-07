package com.entanmo.etmall.db.dao;

import com.entanmo.etmall.db.domain.EtmallRegion;
import com.entanmo.etmall.db.domain.EtmallRegionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EtmallRegionMapper {
    long countByExample(EtmallRegionExample example);

    int deleteByExample(EtmallRegionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EtmallRegion record);

    int insertSelective(EtmallRegion record);

    EtmallRegion selectOneByExample(EtmallRegionExample example);

    EtmallRegion selectOneByExampleSelective(@Param("example") EtmallRegionExample example, @Param("selective") EtmallRegion.Column ... selective);

    List<EtmallRegion> selectByExampleSelective(@Param("example") EtmallRegionExample example, @Param("selective") EtmallRegion.Column ... selective);

    List<EtmallRegion> selectByExample(EtmallRegionExample example);

    EtmallRegion selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") EtmallRegion.Column ... selective);

    EtmallRegion selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") EtmallRegion record, @Param("example") EtmallRegionExample example);

    int updateByExample(@Param("record") EtmallRegion record, @Param("example") EtmallRegionExample example);

    int updateByPrimaryKeySelective(EtmallRegion record);

    int updateByPrimaryKey(EtmallRegion record);
}