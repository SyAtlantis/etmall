package com.entanmo.etmall.db.dao;

import com.entanmo.etmall.db.domain.EtmallTopic;
import com.entanmo.etmall.db.domain.EtmallTopicExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EtmallTopicMapper {
    long countByExample(EtmallTopicExample example);

    int deleteByExample(EtmallTopicExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EtmallTopic record);

    int insertSelective(EtmallTopic record);

    EtmallTopic selectOneByExample(EtmallTopicExample example);

    EtmallTopic selectOneByExampleSelective(@Param("example") EtmallTopicExample example, @Param("selective") EtmallTopic.Column ... selective);

    EtmallTopic selectOneByExampleWithBLOBs(EtmallTopicExample example);

    List<EtmallTopic> selectByExampleSelective(@Param("example") EtmallTopicExample example, @Param("selective") EtmallTopic.Column ... selective);

    List<EtmallTopic> selectByExampleWithBLOBs(EtmallTopicExample example);

    List<EtmallTopic> selectByExample(EtmallTopicExample example);

    EtmallTopic selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") EtmallTopic.Column ... selective);

    EtmallTopic selectByPrimaryKey(Integer id);

    EtmallTopic selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") EtmallTopic record, @Param("example") EtmallTopicExample example);

    int updateByExampleWithBLOBs(@Param("record") EtmallTopic record, @Param("example") EtmallTopicExample example);

    int updateByExample(@Param("record") EtmallTopic record, @Param("example") EtmallTopicExample example);

    int updateByPrimaryKeySelective(EtmallTopic record);

    int updateByPrimaryKeyWithBLOBs(EtmallTopic record);

    int updateByPrimaryKey(EtmallTopic record);

    int logicalDeleteByExample(@Param("example") EtmallTopicExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}