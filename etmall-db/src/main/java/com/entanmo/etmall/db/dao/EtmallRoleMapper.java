package com.entanmo.etmall.db.dao;

import com.entanmo.etmall.db.domain.EtmallRole;
import com.entanmo.etmall.db.domain.EtmallRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EtmallRoleMapper {
    long countByExample(EtmallRoleExample example);

    int deleteByExample(EtmallRoleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EtmallRole record);

    int insertSelective(EtmallRole record);

    EtmallRole selectOneByExample(EtmallRoleExample example);

    EtmallRole selectOneByExampleSelective(@Param("example") EtmallRoleExample example, @Param("selective") EtmallRole.Column ... selective);

    List<EtmallRole> selectByExampleSelective(@Param("example") EtmallRoleExample example, @Param("selective") EtmallRole.Column ... selective);

    List<EtmallRole> selectByExample(EtmallRoleExample example);

    EtmallRole selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") EtmallRole.Column ... selective);

    EtmallRole selectByPrimaryKey(Integer id);

    EtmallRole selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") EtmallRole record, @Param("example") EtmallRoleExample example);

    int updateByExample(@Param("record") EtmallRole record, @Param("example") EtmallRoleExample example);

    int updateByPrimaryKeySelective(EtmallRole record);

    int updateByPrimaryKey(EtmallRole record);

    int logicalDeleteByExample(@Param("example") EtmallRoleExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}