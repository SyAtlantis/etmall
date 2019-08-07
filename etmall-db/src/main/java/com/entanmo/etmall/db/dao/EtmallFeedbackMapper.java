package com.entanmo.etmall.db.dao;

import com.entanmo.etmall.db.domain.EtmallFeedback;
import com.entanmo.etmall.db.domain.EtmallFeedbackExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EtmallFeedbackMapper {
    long countByExample(EtmallFeedbackExample example);

    int deleteByExample(EtmallFeedbackExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EtmallFeedback record);

    int insertSelective(EtmallFeedback record);

    EtmallFeedback selectOneByExample(EtmallFeedbackExample example);

    EtmallFeedback selectOneByExampleSelective(@Param("example") EtmallFeedbackExample example, @Param("selective") EtmallFeedback.Column ... selective);

    List<EtmallFeedback> selectByExampleSelective(@Param("example") EtmallFeedbackExample example, @Param("selective") EtmallFeedback.Column ... selective);

    List<EtmallFeedback> selectByExample(EtmallFeedbackExample example);

    EtmallFeedback selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") EtmallFeedback.Column ... selective);

    EtmallFeedback selectByPrimaryKey(Integer id);

    EtmallFeedback selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") EtmallFeedback record, @Param("example") EtmallFeedbackExample example);

    int updateByExample(@Param("record") EtmallFeedback record, @Param("example") EtmallFeedbackExample example);

    int updateByPrimaryKeySelective(EtmallFeedback record);

    int updateByPrimaryKey(EtmallFeedback record);

    int logicalDeleteByExample(@Param("example") EtmallFeedbackExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}