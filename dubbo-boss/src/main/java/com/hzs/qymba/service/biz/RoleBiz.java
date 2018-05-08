package com.hzs.qymba.service.biz;


import com.alibaba.dubbo.common.logger.Logger;
import com.alibaba.dubbo.common.logger.LoggerFactory;
import com.google.gson.Gson;
import com.hzs.qymba.api.RoleApi;
import com.hzs.qymba.dto.RoleDTO;
import com.hzs.qymba.model.Role;
import com.hzs.qymba.service.RoleService;
import com.util.ParamMap;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RoleBiz implements RoleApi {

    private Logger logger = LoggerFactory.getLogger(RoleBiz.class);

    @Autowired
    private RoleService roleService;


    @Override
    public List<RoleDTO> selectAll() {
        return gsonList(roleService.selectAll());
    }

    @Override
    public Map<String, Object> selectPager(ParamMap param) {
        Map<String, Object> rs = new HashMap<String, Object>();
        // 统计总条数
        long total = roleService.selectCount(param);
        // 翻页计算记录起始
        param.turnPage(total);
        // 获取结果
        rs.put("total", total);
        rs.put("rows", gsonList(roleService.selectList(param)));
        return rs;
    }

    @Override
    public RoleDTO selectByRoleId(Long id) {
        return gsonObject(roleService.selectByRoleId(id));
    }

    /**
     * 类型转换
     * @param roleList
     * @return
     */
    private List<RoleDTO> gsonList(List<Role> roleList){
        List<RoleDTO> roleDTOList = new ArrayList<RoleDTO>();
        Gson gs = new Gson();
        for (Role role:roleList){
            String roleStr = gs.toJson(role);
            RoleDTO roleDTO = gs.fromJson(roleStr,RoleDTO.class);
            roleDTOList.add(roleDTO);
        }
        return roleDTOList;
    }

    private RoleDTO gsonObject(Role role){
        Gson gs = new Gson();
        String roleStr = gs.toJson(role);
        RoleDTO roleDTO = gs.fromJson(roleStr,RoleDTO.class);
        return roleDTO;
    }
}
