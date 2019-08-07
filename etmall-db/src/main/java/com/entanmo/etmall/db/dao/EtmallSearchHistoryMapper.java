package com.entanmo.etmall.db.dao;

import com.entanmo.etmall.db.domain.EtmallSearchHistory;
import com.entanmo.etmall.db.domain.EtmallSearchHistoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EtmallSearchHistoryMapper {
    long countByExample(EtmallSearchHistoryExample example);

    int deleteByExample(EtmallSearchHistoryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EtmallSearchHistory record);

    int insertSelective(EtmallSearchHistory record);

    EtmallSearchHistory selectOneByExample(EtmallSearchHistoryExample example);

    EtmallSearchHistory selectOneByExampleSelective(@Param("example") EtmallSearchHistoryExample example, @Param("selective") EtmallSearchHistory.Column ... selective);

    List<EtmallSearchHistory> selectByExampleSelective(@Param("example") EtmallSearchHistoryExample example, @Param("selective") EtmallSearchHistory.Column ... selective);

    List<EtmallSearchHistory> selectByExample(EtmallSearchHistoryExample example);

    EtmallSearchHistory selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") EtmallSearchHistory.Column ... selective);

    EtmallSearchHistory selectByPrimaryKey(Integer id);

    EtmallSearchHistory selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") EtmallSearchHistory record, @Param("example") EtmallSearchHistoryExample example);

    int updateByExample(@Param("record") EtmallSearchHistory record, @Param("example") EtmallSearchHistoryExample example);

    int updateByPrimaryKeySelective(EtmallSearchHistory record);

    int updateByPrimaryKey(EtmallSearchHistory record);

    int logicalDeleteByExample(@Param("example") EtmallSearchHistoryExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}