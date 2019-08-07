package com.entanmo.etmall.db.dao;

import com.entanmo.etmall.db.domain.EtmallAddress;
import com.entanmo.etmall.db.domain.EtmallAddressExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EtmallAddressMapper {
    long countByExample(EtmallAddressExample example);

    int deleteByExample(EtmallAddressExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EtmallAddress record);

    int insertSelective(EtmallAddress record);

    EtmallAddress selectOneByExample(EtmallAddressExample example);

    EtmallAddress selectOneByExampleSelective(@Param("example") EtmallAddressExample example, @Param("selective") EtmallAddress.Column ... selective);

    List<EtmallAddress> selectByExampleSelective(@Param("example") EtmallAddressExample example, @Param("selective") EtmallAddress.Column ... selective);

    List<EtmallAddress> selectByExample(EtmallAddressExample example);

    EtmallAddress selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") EtmallAddress.Column ... selective);

    EtmallAddress selectByPrimaryKey(Integer id);

    EtmallAddress selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") EtmallAddress record, @Param("example") EtmallAddressExample example);

    int updateByExample(@Param("record") EtmallAddress record, @Param("example") EtmallAddressExample example);

    int updateByPrimaryKeySelective(EtmallAddress record);

    int updateByPrimaryKey(EtmallAddress record);

    int logicalDeleteByExample(@Param("example") EtmallAddressExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}