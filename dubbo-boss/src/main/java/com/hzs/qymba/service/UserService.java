package com.hzs.qymba.service;

import com.hzs.qymba.model.User;
import com.util.ParamMap;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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
     * c
     * @param id
     * @return
     */
    User selectByUserId(Long id);
}
