package com.hzs.qymba.api;

import com.hzs.qymba.dto.MenuDTO;

import java.util.List;

/**
 * 菜单代理类
 */


public interface MenuApi {

    /**
     * 查询所有菜单
     * @return
     */
    List<MenuDTO> selectAll();
}
