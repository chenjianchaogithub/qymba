package com.hzs.qymba.service;

import com.hzs.qymba.model.Permission;
import com.hzs.qymba.model.Permission;
import com.util.ParamMap;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PermissionService {



    /**
     * 查询所有用户
     * @return
     */
    List<Permission> selectAll();

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
    List<Permission> selectList(ParamMap param);

    /**
     * c
     * @param id
     * @return
     */
    Permission selectByPermissionId(Long id);
}
