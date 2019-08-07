package com.entanmo.etmall.db.dao;

import com.entanmo.etmall.db.domain.EtmallGoodsProduct;
import com.entanmo.etmall.db.domain.EtmallGoodsProductExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EtmallGoodsProductMapper {
    long countByExample(EtmallGoodsProductExample example);

    int deleteByExample(EtmallGoodsProductExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EtmallGoodsProduct record);

    int insertSelective(EtmallGoodsProduct record);

    EtmallGoodsProduct selectOneByExample(EtmallGoodsProductExample example);

    EtmallGoodsProduct selectOneByExampleSelective(@Param("example") EtmallGoodsProductExample example, @Param("selective") EtmallGoodsProduct.Column ... selective);

    List<EtmallGoodsProduct> selectByExampleSelective(@Param("example") EtmallGoodsProductExample example, @Param("selective") EtmallGoodsProduct.Column ... selective);

    List<EtmallGoodsProduct> selectByExample(EtmallGoodsProductExample example);

    EtmallGoodsProduct selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") EtmallGoodsProduct.Column ... selective);

    EtmallGoodsProduct selectByPrimaryKey(Integer id);

    EtmallGoodsProduct selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") EtmallGoodsProduct record, @Param("example") EtmallGoodsProductExample example);

    int updateByExample(@Param("record") EtmallGoodsProduct record, @Param("example") EtmallGoodsProductExample example);

    int updateByPrimaryKeySelective(EtmallGoodsProduct record);

    int updateByPrimaryKey(EtmallGoodsProduct record);

    int logicalDeleteByExample(@Param("example") EtmallGoodsProductExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}