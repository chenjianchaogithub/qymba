package com.hzs.qymba.mapper;

import com.hzs.qymba.model.Dept;

import java.util.List;

public interface DeptMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Dept record);

    int insertSelective(Dept record);

    Dept selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Dept record);

    int updateByPrimaryKey(Dept record);

    /**
     * 查询所有菜单
     * @return
     */
    List<Dept> selectAll();
}