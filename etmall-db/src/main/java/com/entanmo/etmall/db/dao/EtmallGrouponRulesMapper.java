package com.entanmo.etmall.db.dao;

import com.entanmo.etmall.db.domain.EtmallGrouponRules;
import com.entanmo.etmall.db.domain.EtmallGrouponRulesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EtmallGrouponRulesMapper {
    long countByExample(EtmallGrouponRulesExample example);

    int deleteByExample(EtmallGrouponRulesExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EtmallGrouponRules record);

    int insertSelective(EtmallGrouponRules record);

    EtmallGrouponRules selectOneByExample(EtmallGrouponRulesExample example);

    EtmallGrouponRules selectOneByExampleSelective(@Param("example") EtmallGrouponRulesExample example, @Param("selective") EtmallGrouponRules.Column ... selective);

    List<EtmallGrouponRules> selectByExampleSelective(@Param("example") EtmallGrouponRulesExample example, @Param("selective") EtmallGrouponRules.Column ... selective);

    List<EtmallGrouponRules> selectByExample(EtmallGrouponRulesExample example);

    EtmallGrouponRules selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") EtmallGrouponRules.Column ... selective);

    EtmallGrouponRules selectByPrimaryKey(Integer id);

    EtmallGrouponRules selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") EtmallGrouponRules record, @Param("example") EtmallGrouponRulesExample example);

    int updateByExample(@Param("record") EtmallGrouponRules record, @Param("example") EtmallGrouponRulesExample example);

    int updateByPrimaryKeySelective(EtmallGrouponRules record);

    int updateByPrimaryKey(EtmallGrouponRules record);

    int logicalDeleteByExample(@Param("example") EtmallGrouponRulesExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}