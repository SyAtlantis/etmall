package com.entanmo.etmall.db.dao;

import com.entanmo.etmall.db.domain.EtmallDraw;
import com.entanmo.etmall.db.domain.EtmallDrawExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EtmallDrawMapper {
    long countByExample(EtmallDrawExample example);

    int deleteByExample(EtmallDrawExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EtmallDraw record);

    int insertSelective(EtmallDraw record);

    EtmallDraw selectOneByExample(EtmallDrawExample example);

    EtmallDraw selectOneByExampleSelective(@Param("example") EtmallDrawExample example, @Param("selective") EtmallDraw.Column ... selective);

    List<EtmallDraw> selectByExampleSelective(@Param("example") EtmallDrawExample example, @Param("selective") EtmallDraw.Column ... selective);

    List<EtmallDraw> selectByExample(EtmallDrawExample example);

    EtmallDraw selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") EtmallDraw.Column ... selective);

    EtmallDraw selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") EtmallDraw record, @Param("example") EtmallDrawExample example);

    int updateByExample(@Param("record") EtmallDraw record, @Param("example") EtmallDrawExample example);

    int updateByPrimaryKeySelective(EtmallDraw record);

    int updateByPrimaryKey(EtmallDraw record);
}