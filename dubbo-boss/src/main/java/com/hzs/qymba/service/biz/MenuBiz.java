package com.hzs.qymba.service.biz;


import com.alibaba.dubbo.common.logger.Logger;
import com.alibaba.dubbo.common.logger.LoggerFactory;
import com.hzs.qymba.api.MenuApi;
import com.hzs.qymba.dto.MenuDTO;
import com.hzs.qymba.model.Menu;
import com.hzs.qymba.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MenuBiz implements MenuApi {

    private Logger logger = LoggerFactory.getLogger(MenuBiz.class);

    @Autowired
    private MenuService menuService;


    /**
     * 查询所有菜单
     * @return
     */
    @Override
    public List<MenuDTO> selectAll() {
        List<Menu> menuList = menuService.selectAll();//数据库数据
        List<MenuDTO> menuDTOList = new ArrayList<>();
        for (Menu menu : menuList){
            MenuDTO menuDTO = new MenuDTO();
            menuDTO.setHref(menu.getHref());
            menuDTO.setId(menu.getId());
            menuDTO.setName(menu.getName());
            menuDTO.setParentid(menu.getParentid());
            menuDTO.setCode(menu.getCode());
            menuDTO.setPcode(menu.getPcode());
            menuDTOList.add(menuDTO);
        }
        return menuDTOList;
    }
}
