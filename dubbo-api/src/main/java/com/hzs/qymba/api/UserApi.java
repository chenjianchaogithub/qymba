package com.hzs.qymba.api;

import com.hzs.qymba.dto.UserDTO;
import com.util.ParamMap;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;

import java.util.List;
import java.util.Map;


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


    /**
     * 分页查询
     * @param param
     * @return
     */
    Map<String, Object> selectPager(ParamMap param);

    /**
     * 查询单个用户
     * @param id
     * @return
     */
    UserDTO selectByUserId(Long id);
}
