package com.hzs.qymba.api;

import com.hzs.qymba.dto.UserDTO;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;


public interface UserApi {
    UserDTO authentication(AuthenticationToken token) throws AuthenticationException;

}
