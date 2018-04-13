package com.hzs.qymba.service.impl;

import com.hzs.qymba.mapper.MenuMapper;
import com.hzs.qymba.model.Menu;
import com.hzs.qymba.service.MenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {
    @Resource
    private MenuMapper menuMapper;


    @Override
    public List<Menu> selectAll() {
        return menuMapper.selectAll();
    }
}
