package com.entanmo.etmall.db.dao;

import com.entanmo.etmall.db.domain.EtmallIssue;
import com.entanmo.etmall.db.domain.EtmallIssueExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EtmallIssueMapper {
    long countByExample(EtmallIssueExample example);

    int deleteByExample(EtmallIssueExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EtmallIssue record);

    int insertSelective(EtmallIssue record);

    EtmallIssue selectOneByExample(EtmallIssueExample example);

    EtmallIssue selectOneByExampleSelective(@Param("example") EtmallIssueExample example, @Param("selective") EtmallIssue.Column ... selective);

    List<EtmallIssue> selectByExampleSelective(@Param("example") EtmallIssueExample example, @Param("selective") EtmallIssue.Column ... selective);

    List<EtmallIssue> selectByExample(EtmallIssueExample example);

    EtmallIssue selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") EtmallIssue.Column ... selective);

    EtmallIssue selectByPrimaryKey(Integer id);

    EtmallIssue selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") EtmallIssue record, @Param("example") EtmallIssueExample example);

    int updateByExample(@Param("record") EtmallIssue record, @Param("example") EtmallIssueExample example);

    int updateByPrimaryKeySelective(EtmallIssue record);

    int updateByPrimaryKey(EtmallIssue record);

    int logicalDeleteByExample(@Param("example") EtmallIssueExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}