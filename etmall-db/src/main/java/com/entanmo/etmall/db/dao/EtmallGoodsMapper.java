package com.entanmo.etmall.db.dao;

import com.entanmo.etmall.db.domain.EtmallGoods;
import com.entanmo.etmall.db.domain.EtmallGoodsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EtmallGoodsMapper {
    long countByExample(EtmallGoodsExample example);

    int deleteByExample(EtmallGoodsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EtmallGoods record);

    int insertSelective(EtmallGoods record);

    EtmallGoods selectOneByExample(EtmallGoodsExample example);

    EtmallGoods selectOneByExampleSelective(@Param("example") EtmallGoodsExample example, @Param("selective") EtmallGoods.Column ... selective);

    EtmallGoods selectOneByExampleWithBLOBs(EtmallGoodsExample example);

    List<EtmallGoods> selectByExampleSelective(@Param("example") EtmallGoodsExample example, @Param("selective") EtmallGoods.Column ... selective);

    List<EtmallGoods> selectByExampleWithBLOBs(EtmallGoodsExample example);

    List<EtmallGoods> selectByExample(EtmallGoodsExample example);

    EtmallGoods selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") EtmallGoods.Column ... selective);

    EtmallGoods selectByPrimaryKey(Integer id);

    EtmallGoods selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") EtmallGoods record, @Param("example") EtmallGoodsExample example);

    int updateByExampleWithBLOBs(@Param("record") EtmallGoods record, @Param("example") EtmallGoodsExample example);

    int updateByExample(@Param("record") EtmallGoods record, @Param("example") EtmallGoodsExample example);

    int updateByPrimaryKeySelective(EtmallGoods record);

    int updateByPrimaryKeyWithBLOBs(EtmallGoods record);

    int updateByPrimaryKey(EtmallGoods record);

    int logicalDeleteByExample(@Param("example") EtmallGoodsExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}