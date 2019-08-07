package com.entanmo.etmall.db.dao;

import com.entanmo.etmall.db.domain.EtmallOrderGoods;
import com.entanmo.etmall.db.domain.EtmallOrderGoodsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EtmallOrderGoodsMapper {
    long countByExample(EtmallOrderGoodsExample example);

    int deleteByExample(EtmallOrderGoodsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EtmallOrderGoods record);

    int insertSelective(EtmallOrderGoods record);

    EtmallOrderGoods selectOneByExample(EtmallOrderGoodsExample example);

    EtmallOrderGoods selectOneByExampleSelective(@Param("example") EtmallOrderGoodsExample example, @Param("selective") EtmallOrderGoods.Column ... selective);

    List<EtmallOrderGoods> selectByExampleSelective(@Param("example") EtmallOrderGoodsExample example, @Param("selective") EtmallOrderGoods.Column ... selective);

    List<EtmallOrderGoods> selectByExample(EtmallOrderGoodsExample example);

    EtmallOrderGoods selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") EtmallOrderGoods.Column ... selective);

    EtmallOrderGoods selectByPrimaryKey(Integer id);

    EtmallOrderGoods selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") EtmallOrderGoods record, @Param("example") EtmallOrderGoodsExample example);

    int updateByExample(@Param("record") EtmallOrderGoods record, @Param("example") EtmallOrderGoodsExample example);

    int updateByPrimaryKeySelective(EtmallOrderGoods record);

    int updateByPrimaryKey(EtmallOrderGoods record);

    int logicalDeleteByExample(@Param("example") EtmallOrderGoodsExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}