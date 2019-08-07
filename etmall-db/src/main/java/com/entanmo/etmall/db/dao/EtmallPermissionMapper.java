package com.entanmo.etmall.db.dao;

import com.entanmo.etmall.db.domain.EtmallPermission;
import com.entanmo.etmall.db.domain.EtmallPermissionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EtmallPermissionMapper {
    long countByExample(EtmallPermissionExample example);

    int deleteByExample(EtmallPermissionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EtmallPermission record);

    int insertSelective(EtmallPermission record);

    EtmallPermission selectOneByExample(EtmallPermissionExample example);

    EtmallPermission selectOneByExampleSelective(@Param("example") EtmallPermissionExample example, @Param("selective") EtmallPermission.Column ... selective);

    List<EtmallPermission> selectByExampleSelective(@Param("example") EtmallPermissionExample example, @Param("selective") EtmallPermission.Column ... selective);

    List<EtmallPermission> selectByExample(EtmallPermissionExample example);

    EtmallPermission selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") EtmallPermission.Column ... selective);

    EtmallPermission selectByPrimaryKey(Integer id);

    EtmallPermission selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") EtmallPermission record, @Param("example") EtmallPermissionExample example);

    int updateByExample(@Param("record") EtmallPermission record, @Param("example") EtmallPermissionExample example);

    int updateByPrimaryKeySelective(EtmallPermission record);

    int updateByPrimaryKey(EtmallPermission record);

    int logicalDeleteByExample(@Param("example") EtmallPermissionExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}