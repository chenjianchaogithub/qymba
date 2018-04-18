package com.hzs.qymba.service.impl;

import com.hzs.qymba.mapper.UserMapper;
import com.hzs.qymba.model.User;
import com.hzs.qymba.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public User authentication(AuthenticationToken token) throws AuthenticationException {
        // 经过安全框架的用户名和密码
        String username = String.valueOf(token.getPrincipal());
        String password = new String((char[]) token.getCredentials());
        // 查数据库
        try {

            final User user = userMapper.authentication(username, password);
            // 用户信息有问题
           /* if (user == null)
                throw new AuthenticationException(G.getMsg("user.login.err.token"));*/
            // 注销状态不能登录系统
            /*if (user.getState() == User.State.DISABLE.getCode())
                throw new AuthenticationException(G.getMsg("user.login.delete"));*/
            // 验证成功
            return user;
        } catch(Exception e) {
            e.printStackTrace();
            throw new AuthenticationException(e.getMessage());
        }
    }

    public List<User> selectAll(){
        return userMapper.selectAll();
    }
}
