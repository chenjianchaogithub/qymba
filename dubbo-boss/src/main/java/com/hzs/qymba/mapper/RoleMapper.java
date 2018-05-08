package com.hzs.qymba.mapper;

import com.hzs.qymba.model.Role;
import com.util.ParamMap;

import java.util.List;

public interface RoleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);


    /**
     * 查询所有用户列表
     * @return
     */
    List<Role> selectAll();

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
    List<Role> selectList(ParamMap param);

    /**
     * 查询单个用户
     * @param id
     * @return
     */
    Role selectByRoleId(Long id);
}