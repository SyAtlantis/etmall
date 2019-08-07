package com.entanmo.etmall.db.dao;

import com.entanmo.etmall.db.domain.EtmallKeyword;
import com.entanmo.etmall.db.domain.EtmallKeywordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EtmallKeywordMapper {
    long countByExample(EtmallKeywordExample example);

    int deleteByExample(EtmallKeywordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EtmallKeyword record);

    int insertSelective(EtmallKeyword record);

    EtmallKeyword selectOneByExample(EtmallKeywordExample example);

    EtmallKeyword selectOneByExampleSelective(@Param("example") EtmallKeywordExample example, @Param("selective") EtmallKeyword.Column ... selective);

    List<EtmallKeyword> selectByExampleSelective(@Param("example") EtmallKeywordExample example, @Param("selective") EtmallKeyword.Column ... selective);

    List<EtmallKeyword> selectByExample(EtmallKeywordExample example);

    EtmallKeyword selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") EtmallKeyword.Column ... selective);

    EtmallKeyword selectByPrimaryKey(Integer id);

    EtmallKeyword selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") EtmallKeyword record, @Param("example") EtmallKeywordExample example);

    int updateByExample(@Param("record") EtmallKeyword record, @Param("example") EtmallKeywordExample example);

    int updateByPrimaryKeySelective(EtmallKeyword record);

    int updateByPrimaryKey(EtmallKeyword record);

    int logicalDeleteByExample(@Param("example") EtmallKeywordExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}