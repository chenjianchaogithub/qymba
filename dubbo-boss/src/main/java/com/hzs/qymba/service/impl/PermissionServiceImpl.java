package com.hzs.qymba.service.impl;

import com.hzs.qymba.mapper.PermissionMapper;
import com.hzs.qymba.model.Permission;
import com.hzs.qymba.service.PermissionService;
import com.util.ParamMap;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {
    @Resource
    private PermissionMapper permissionMapper;


    public List<Permission> selectAll(){
        return permissionMapper.selectAll();
    }


    @Override
    public long selectCount(ParamMap param) {
        return permissionMapper.selectCount(param);
    }

    @Override
    public List<Permission> selectList(ParamMap param) {
        return permissionMapper.selectList(param);
    }

    @Override
    public Permission selectByPermissionId(Long id) {
        return permissionMapper.selectByPermissionId(id);
    }
}
