package com.hzs.qymba.api;

import com.hzs.qymba.dto.RoleDTO;
import com.util.ParamMap;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;

import java.util.List;
import java.util.Map;


public interface RoleApi {
    

    /**
     * 查询所有用户
     * @return
     */
    List<RoleDTO> selectAll();


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
    RoleDTO selectByRoleId(Long id);
}