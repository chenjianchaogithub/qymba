package com.hzs.qymba.mapper;


import com.core.generic.GenericMapper;
import com.hzs.qymba.model.User;
import com.util.ParamMap;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper extends GenericMapper<User>{

    /**
     * 身份验证
     *
     * @param username
     * @param password
     * @return
     */
    User authentication(@Param("username") String username,
                        @Param("password") String password);


    /**
     * 查询所有用户列表
     * @return
     */
    List<User> selectAll();

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
    List<User> selectList(ParamMap param);

    /**
     * 查询单个用户
     * @param id
     * @return
     */
    User selectByUserId(Long id);
}