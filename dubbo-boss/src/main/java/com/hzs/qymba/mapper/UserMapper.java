package com.hzs.qymba.mapper;


import com.hzs.qymba.model.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    /**
     * 身份验证
     *
     * @param username
     * @param password
     * @return
     */
    User authentication(@Param("username") String username,
                        @Param("password") String password);

}