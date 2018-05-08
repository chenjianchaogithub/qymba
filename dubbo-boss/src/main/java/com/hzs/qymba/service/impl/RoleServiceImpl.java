package com.hzs.qymba.service.impl;

import com.hzs.qymba.mapper.RoleMapper;
import com.hzs.qymba.model.Role;
import com.hzs.qymba.service.RoleService;
import com.util.ParamMap;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Resource
    private RoleMapper roleMapper;


    public List<Role> selectAll(){
        return roleMapper.selectAll();
    }


    @Override
    public long selectCount(ParamMap param) {
        return roleMapper.selectCount(param);
    }

    @Override
    public List<Role> selectList(ParamMap param) {
        return roleMapper.selectList(param);
    }

    @Override
    public Role selectByRoleId(Long id) {
        return roleMapper.selectByRoleId(id);
    }
}
