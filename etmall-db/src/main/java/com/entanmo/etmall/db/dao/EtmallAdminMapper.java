package com.entanmo.etmall.db.dao;

import com.entanmo.etmall.db.domain.EtmallAdmin;
import com.entanmo.etmall.db.domain.EtmallAdminExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EtmallAdminMapper {
    long countByExample(EtmallAdminExample example);

    int deleteByExample(EtmallAdminExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EtmallAdmin record);

    int insertSelective(EtmallAdmin record);

    EtmallAdmin selectOneByExample(EtmallAdminExample example);

    EtmallAdmin selectOneByExampleSelective(@Param("example") EtmallAdminExample example, @Param("selective") EtmallAdmin.Column ... selective);

    List<EtmallAdmin> selectByExampleSelective(@Param("example") EtmallAdminExample example, @Param("selective") EtmallAdmin.Column ... selective);

    List<EtmallAdmin> selectByExample(EtmallAdminExample example);

    EtmallAdmin selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") EtmallAdmin.Column ... selective);

    EtmallAdmin selectByPrimaryKey(Integer id);

    EtmallAdmin selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") EtmallAdmin record, @Param("example") EtmallAdminExample example);

    int updateByExample(@Param("record") EtmallAdmin record, @Param("example") EtmallAdminExample example);

    int updateByPrimaryKeySelective(EtmallAdmin record);

    int updateByPrimaryKey(EtmallAdmin record);

    int logicalDeleteByExample(@Param("example") EtmallAdminExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}