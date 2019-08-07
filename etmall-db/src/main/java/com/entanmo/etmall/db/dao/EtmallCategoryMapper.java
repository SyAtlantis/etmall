package com.entanmo.etmall.db.dao;

import com.entanmo.etmall.db.domain.EtmallCategory;
import com.entanmo.etmall.db.domain.EtmallCategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EtmallCategoryMapper {
    long countByExample(EtmallCategoryExample example);

    int deleteByExample(EtmallCategoryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EtmallCategory record);

    int insertSelective(EtmallCategory record);

    EtmallCategory selectOneByExample(EtmallCategoryExample example);

    EtmallCategory selectOneByExampleSelective(@Param("example") EtmallCategoryExample example, @Param("selective") EtmallCategory.Column ... selective);

    List<EtmallCategory> selectByExampleSelective(@Param("example") EtmallCategoryExample example, @Param("selective") EtmallCategory.Column ... selective);

    List<EtmallCategory> selectByExample(EtmallCategoryExample example);

    EtmallCategory selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") EtmallCategory.Column ... selective);

    EtmallCategory selectByPrimaryKey(Integer id);

    EtmallCategory selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    int updateByExampleSelective(@Param("record") EtmallCategory record, @Param("example") EtmallCategoryExample example);

    int updateByExample(@Param("record") EtmallCategory record, @Param("example") EtmallCategoryExample example);

    int updateByPrimaryKeySelective(EtmallCategory record);

    int updateByPrimaryKey(EtmallCategory record);

    int logicalDeleteByExample(@Param("example") EtmallCategoryExample example);

    int logicalDeleteByPrimaryKey(Integer id);
}