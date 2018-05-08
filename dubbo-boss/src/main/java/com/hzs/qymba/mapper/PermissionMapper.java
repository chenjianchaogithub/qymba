package com.hzs.qymba.mapper;

import com.hzs.qymba.model.Permission;
import com.util.ParamMap;

import java.util.List;

public interface PermissionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Permission record);

    int insertSelective(Permission record);

    Permission selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);


    /**
     * 查询所有用户列表
     * @return
     */
    List<Permission> selectAll();

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
    List<Permission> selectList(ParamMap param);

    /**
     * 查询单个用户
     * @param id
     * @return
     */
    Permission selectByPermissionId(Long id);
}