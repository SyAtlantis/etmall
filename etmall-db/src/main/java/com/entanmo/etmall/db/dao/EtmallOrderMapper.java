package com.entanmo.etmall.db.dao;

import com.entanmo.etmall.db.domain.EtmallOrder;
import com.entanmo.etmall.db.domain.EtmallOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EtmallOrderMapper {
    long countByExample(EtmallOrderExample example);

    int deleteByExample(EtmallOrderExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EtmallOrder record);

    int insertSelective(EtmallOrder record);

    EtmallOrder selectOneByExample(EtmallOrderExample example);

    EtmallOrder selectOneByExampleSelective(@Param("example") EtmallOrderExample example, @Param("selective") EtmallOrder.Column ... selective);

    List<EtmallOrder> selectByExampleSelective(@Param("example") EtmallOrderExample example, @Param("selective") EtmallOrder.Column ... selective);

    List<EtmallOrder> selectByExample(EtmallOrderExample example);

    EtmallOrder selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") EtmallOrder.Column ... selective);

    EtmallOrder selectByPrimaryKey(Integer id);

    EtmallOrder selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") EtmallOrder record, @Param("example") EtmallOrderExample example);

    int updateByExample(@Param("record") EtmallOrder record, @Param("example") EtmallOrderExample example);

    int updateByPrimaryKeySelective(EtmallOrder record);

    int updateByPrimaryKey(EtmallOrder record);

    int logicalDeleteByExample(@Param("example") EtmallOrderExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}