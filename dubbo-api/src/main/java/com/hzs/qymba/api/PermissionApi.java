package com.hzs.qymba.api;

import com.hzs.qymba.dto.PermissionDTO;
import com.util.ParamMap;

import java.util.List;
import java.util.Map;


public interface PermissionApi {
    

    /**
     * 查询所有用户
     * @return
     */
    List<PermissionDTO> selectAll();


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
    PermissionDTO selectByPermissionId(Long id);
}
