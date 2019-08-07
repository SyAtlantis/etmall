package com.entanmo.etmall.db.dao;

import com.entanmo.etmall.db.domain.EtmallGoodsSpecification;
import com.entanmo.etmall.db.domain.EtmallGoodsSpecificationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EtmallGoodsSpecificationMapper {
    long countByExample(EtmallGoodsSpecificationExample example);

    int deleteByExample(EtmallGoodsSpecificationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EtmallGoodsSpecification record);

    int insertSelective(EtmallGoodsSpecification record);

    EtmallGoodsSpecification selectOneByExample(EtmallGoodsSpecificationExample example);

    EtmallGoodsSpecification selectOneByExampleSelective(@Param("example") EtmallGoodsSpecificationExample example, @Param("selective") EtmallGoodsSpecification.Column ... selective);

    List<EtmallGoodsSpecification> selectByExampleSelective(@Param("example") EtmallGoodsSpecificationExample example, @Param("selective") EtmallGoodsSpecification.Column ... selective);

    List<EtmallGoodsSpecification> selectByExample(EtmallGoodsSpecificationExample example);

    EtmallGoodsSpecification selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") EtmallGoodsSpecification.Column ... selective);

    EtmallGoodsSpecification selectByPrimaryKey(Integer id);

    EtmallGoodsSpecification selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") EtmallGoodsSpecification record, @Param("example") EtmallGoodsSpecificationExample example);

    int updateByExample(@Param("record") EtmallGoodsSpecification record, @Param("example") EtmallGoodsSpecificationExample example);

    int updateByPrimaryKeySelective(EtmallGoodsSpecification record);

    int updateByPrimaryKey(EtmallGoodsSpecification record);

    int logicalDeleteByExample(@Param("example") EtmallGoodsSpecificationExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}