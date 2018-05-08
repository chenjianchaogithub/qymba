package com.hzs.qymba.service.biz;


import com.alibaba.dubbo.common.logger.Logger;
import com.alibaba.dubbo.common.logger.LoggerFactory;
import com.google.gson.Gson;
import com.hzs.qymba.api.PermissionApi;
import com.hzs.qymba.dto.PermissionDTO;
import com.hzs.qymba.model.Permission;
import com.hzs.qymba.service.PermissionService;
import com.util.ParamMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PermissionBiz implements PermissionApi {

    private Logger logger = LoggerFactory.getLogger(PermissionBiz.class);

    @Autowired
    private PermissionService permissionService;


    @Override
    public List<PermissionDTO> selectAll() {
        return gsonList(permissionService.selectAll());
    }

    @Override
    public Map<String, Object> selectPager(ParamMap param) {
        Map<String, Object> rs = new HashMap<String, Object>();
        // 统计总条数
        long total = permissionService.selectCount(param);
        // 翻页计算记录起始
        param.turnPage(total);
        // 获取结果
        rs.put("total", total);
        rs.put("rows", gsonList(permissionService.selectList(param)));
        return rs;
    }

    @Override
    public PermissionDTO selectByPermissionId(Long id) {
        return gsonObject(permissionService.selectByPermissionId(id));
    }

    /**
     * 类型转换
     * @param permissionList
     * @return
     */
    private List<PermissionDTO> gsonList(List<Permission> permissionList){
        List<PermissionDTO> permissionDTOList = new ArrayList<PermissionDTO>();
        Gson gs = new Gson();
        for (Permission permission:permissionList){
            String permissionStr = gs.toJson(permission);
            PermissionDTO permissionDTO = gs.fromJson(permissionStr,PermissionDTO.class);
            permissionDTOList.add(permissionDTO);
        }
        return permissionDTOList;
    }

    private PermissionDTO gsonObject(Permission permission){
        Gson gs = new Gson();
        String permissionStr = gs.toJson(permission);
        PermissionDTO permissionDTO = gs.fromJson(permissionStr,PermissionDTO.class);
        return permissionDTO;
    }
}
