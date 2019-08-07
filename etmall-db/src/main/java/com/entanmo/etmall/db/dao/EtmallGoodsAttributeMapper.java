package com.entanmo.etmall.db.dao;

import com.entanmo.etmall.db.domain.EtmallGoodsAttribute;
import com.entanmo.etmall.db.domain.EtmallGoodsAttributeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EtmallGoodsAttributeMapper {
    long countByExample(EtmallGoodsAttributeExample example);

    int deleteByExample(EtmallGoodsAttributeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EtmallGoodsAttribute record);

    int insertSelective(EtmallGoodsAttribute record);

    EtmallGoodsAttribute selectOneByExample(EtmallGoodsAttributeExample example);

    EtmallGoodsAttribute selectOneByExampleSelective(@Param("example") EtmallGoodsAttributeExample example, @Param("selective") EtmallGoodsAttribute.Column ... selective);

    List<EtmallGoodsAttribute> selectByExampleSelective(@Param("example") EtmallGoodsAttributeExample example, @Param("selective") EtmallGoodsAttribute.Column ... selective);

    List<EtmallGoodsAttribute> selectByExample(EtmallGoodsAttributeExample example);

    EtmallGoodsAttribute selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") EtmallGoodsAttribute.Column ... selective);

    EtmallGoodsAttribute selectByPrimaryKey(Integer id);

    EtmallGoodsAttribute selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") EtmallGoodsAttribute record, @Param("example") EtmallGoodsAttributeExample example);

    int updateByExample(@Param("record") EtmallGoodsAttribute record, @Param("example") EtmallGoodsAttributeExample example);

    int updateByPrimaryKeySelective(EtmallGoodsAttribute record);

    int updateByPrimaryKey(EtmallGoodsAttribute record);

    int logicalDeleteByExample(@Param("example") EtmallGoodsAttributeExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}