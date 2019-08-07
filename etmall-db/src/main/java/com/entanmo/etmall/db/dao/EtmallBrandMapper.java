package com.entanmo.etmall.db.dao;

import com.entanmo.etmall.db.domain.EtmallBrand;
import com.entanmo.etmall.db.domain.EtmallBrandExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EtmallBrandMapper {
    long countByExample(EtmallBrandExample example);

    int deleteByExample(EtmallBrandExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EtmallBrand record);

    int insertSelective(EtmallBrand record);

    EtmallBrand selectOneByExample(EtmallBrandExample example);

    EtmallBrand selectOneByExampleSelective(@Param("example") EtmallBrandExample example, @Param("selective") EtmallBrand.Column ... selective);

    List<EtmallBrand> selectByExampleSelective(@Param("example") EtmallBrandExample example, @Param("selective") EtmallBrand.Column ... selective);

    List<EtmallBrand> selectByExample(EtmallBrandExample example);

    EtmallBrand selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") EtmallBrand.Column ... selective);

    EtmallBrand selectByPrimaryKey(Integer id);

    EtmallBrand selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") EtmallBrand record, @Param("example") EtmallBrandExample example);

    int updateByExample(@Param("record") EtmallBrand record, @Param("example") EtmallBrandExample example);

    int updateByPrimaryKeySelective(EtmallBrand record);

    int updateByPrimaryKey(EtmallBrand record);

    int logicalDeleteByExample(@Param("example") EtmallBrandExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}