package com.hzs.qymba.service;

import com.hzs.qymba.model.User;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    /**
     * 用户验证
     *
     * @param token
     * @return
     * @throws AuthenticationException
     */
    User authentication(AuthenticationToken token) throws AuthenticationException;

    /**
     * 查询所有用户
     * @return
     */
    List<User> selectAll();

}
