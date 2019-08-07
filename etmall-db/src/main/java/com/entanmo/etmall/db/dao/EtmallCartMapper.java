package com.entanmo.etmall.db.dao;

import com.entanmo.etmall.db.domain.EtmallCart;
import com.entanmo.etmall.db.domain.EtmallCartExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EtmallCartMapper {
    long countByExample(EtmallCartExample example);

    int deleteByExample(EtmallCartExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EtmallCart record);

    int insertSelective(EtmallCart record);

    EtmallCart selectOneByExample(EtmallCartExample example);

    EtmallCart selectOneByExampleSelective(@Param("example") EtmallCartExample example, @Param("selective") EtmallCart.Column ... selective);

    List<EtmallCart> selectByExampleSelective(@Param("example") EtmallCartExample example, @Param("selective") EtmallCart.Column ... selective);

    List<EtmallCart> selectByExample(EtmallCartExample example);

    EtmallCart selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") EtmallCart.Column ... selective);

    EtmallCart selectByPrimaryKey(Integer id);

    EtmallCart selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") EtmallCart record, @Param("example") EtmallCartExample example);

    int updateByExample(@Param("record") EtmallCart record, @Param("example") EtmallCartExample example);

    int updateByPrimaryKeySelective(EtmallCart record);

    int updateByPrimaryKey(EtmallCart record);

    int logicalDeleteByExample(@Param("example") EtmallCartExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}