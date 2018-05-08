package com.hzs.qymba.service;

import com.hzs.qymba.model.Role;
import com.util.ParamMap;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RoleService {



    /**
     * 查询所有用户
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
     * c
     * @param id
     * @return
     */
    Role selectByRoleId(Long id);
}
