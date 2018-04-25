package com.hzs.qymba.mapper;

import com.hzs.qymba.model.Amiba;

import java.util.List;

public interface AmibaMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Amiba record);

    int insertSelective(Amiba record);

    Amiba selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Amiba record);

    int updateByPrimaryKey(Amiba record);

    /**
     * 查询所有菜单
     * @return
     */
    List<Amiba> selectAll();
}