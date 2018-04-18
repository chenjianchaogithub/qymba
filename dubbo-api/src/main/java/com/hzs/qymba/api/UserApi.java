package com.hzs.qymba.api;

import com.hzs.qymba.dto.UserDTO;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;

import java.util.List;


public interface UserApi {

    /**
     * 查询用户权限
     * @param token
     * @return
     * @throws AuthenticationException
     */
    UserDTO authentication(AuthenticationToken token) throws AuthenticationException;

    /**
     * 查询所有用户
     * @return
     */
    List<UserDTO> selectAll();
}
