package com.entanmo.etmall.db.dao;

import com.entanmo.etmall.db.domain.EtmallGroupon;
import com.entanmo.etmall.db.domain.EtmallGrouponExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EtmallGrouponMapper {
    long countByExample(EtmallGrouponExample example);

    int deleteByExample(EtmallGrouponExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EtmallGroupon record);

    int insertSelective(EtmallGroupon record);

    EtmallGroupon selectOneByExample(EtmallGrouponExample example);

    EtmallGroupon selectOneByExampleSelective(@Param("example") EtmallGrouponExample example, @Param("selective") EtmallGroupon.Column ... selective);

    List<EtmallGroupon> selectByExampleSelective(@Param("example") EtmallGrouponExample example, @Param("selective") EtmallGroupon.Column ... selective);

    List<EtmallGroupon> selectByExample(EtmallGrouponExample example);

    EtmallGroupon selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") EtmallGroupon.Column ... selective);

    EtmallGroupon selectByPrimaryKey(Integer id);

    EtmallGroupon selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") EtmallGroupon record, @Param("example") EtmallGrouponExample example);

    int updateByExample(@Param("record") EtmallGroupon record, @Param("example") EtmallGrouponExample example);

    int updateByPrimaryKeySelective(EtmallGroupon record);

    int updateByPrimaryKey(EtmallGroupon record);

    int logicalDeleteByExample(@Param("example") EtmallGrouponExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}