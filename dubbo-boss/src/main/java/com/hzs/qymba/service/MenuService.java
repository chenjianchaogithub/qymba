package com.hzs.qymba.service;

import com.hzs.qymba.model.Menu;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MenuService {

    /**
     * 查询所有菜单
     * @return
     */
    List<Menu> selectAll();

}
