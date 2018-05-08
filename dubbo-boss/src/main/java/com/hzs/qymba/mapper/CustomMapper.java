package com.hzs.qymba.mapper;

import com.hzs.qymba.model.Custom;
import com.util.ParamMap;

import java.util.List;

public interface CustomMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Custom record);

    int insertSelective(Custom record);

    Custom selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Custom record);

    int updateByPrimaryKey(Custom record);

    /**
     * 查询所有列表
     * @return
     */
    List<Custom> selectAll();

    /**
     * 带分页的分页计数查询
     * @param param
     * @return
     */
    long selectCount(ParamMap param);

    /**
     * 通过参数集，查询列表
     *
     * @param param
     * @return
     */
    List<Custom> selectList(ParamMap param);

    /**
     * 查询单个用户
     * @param id
     * @return
     */
    Custom selectByCustomId(Long id);
}