package com.entanmo.etmall.db.dao;

import com.entanmo.etmall.db.domain.EtmallComment;
import com.entanmo.etmall.db.domain.EtmallCommentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EtmallCommentMapper {
    long countByExample(EtmallCommentExample example);

    int deleteByExample(EtmallCommentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EtmallComment record);

    int insertSelective(EtmallComment record);

    EtmallComment selectOneByExample(EtmallCommentExample example);

    EtmallComment selectOneByExampleSelective(@Param("example") EtmallCommentExample example, @Param("selective") EtmallComment.Column ... selective);

    List<EtmallComment> selectByExampleSelective(@Param("example") EtmallCommentExample example, @Param("selective") EtmallComment.Column ... selective);

    List<EtmallComment> selectByExample(EtmallCommentExample example);

    EtmallComment selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") EtmallComment.Column ... selective);

    EtmallComment selectByPrimaryKey(Integer id);

    EtmallComment selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") EtmallComment record, @Param("example") EtmallCommentExample example);

    int updateByExample(@Param("record") EtmallComment record, @Param("example") EtmallCommentExample example);

    int updateByPrimaryKeySelective(EtmallComment record);

    int updateByPrimaryKey(EtmallComment record);

    int logicalDeleteByExample(@Param("example") EtmallCommentExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}