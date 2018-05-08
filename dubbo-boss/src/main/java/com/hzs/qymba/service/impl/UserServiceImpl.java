package com.hzs.qymba.service.impl;

import com.core.generic.GenericServiceImpl;
import com.hzs.qymba.mapper.UserMapper;
import com.hzs.qymba.model.User;
import com.hzs.qymba.service.UserService;
import com.util.ParamMap;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

@Service
public class UserServiceImpl extends GenericServiceImpl<UserMapper, User> implements UserService {


    @Override
    public User authentication(AuthenticationToken token) throws AuthenticationException {
        // 经过安全框架的用户名和密码
        String username = String.valueOf(token.getPrincipal());
        String password = new String((char[]) token.getCredentials());
        // 查数据库
        try {

            final User user = this.baseMapper.authentication(username, password);
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
        return this.baseMapper.selectAll();
    }


    @Override
    public long selectCount(ParamMap param) {
        return this.baseMapper.selectCount(param);
    }

    @Override
    public List<User> selectList(ParamMap param) {
        return this.baseMapper.selectList(param);
    }

    @Override
    public User selectByUserId(Long id) {
        return this.baseMapper.selectByUserId(id);
    }
}
