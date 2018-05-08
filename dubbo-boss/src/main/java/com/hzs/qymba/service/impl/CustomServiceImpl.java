package com.hzs.qymba.service.impl;

import com.hzs.qymba.mapper.CustomMapper;
import com.hzs.qymba.model.Custom;
import com.hzs.qymba.service.CustomService;
import com.util.ParamMap;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CustomServiceImpl implements CustomService {
    @Resource
    private CustomMapper customMapper;


    @Override
    public List<Custom> selectAll() {
        return customMapper.selectAll();
    }



    @Override
    public long selectCount(ParamMap param) {
        return customMapper.selectCount(param);
    }

    @Override
    public List<Custom> selectList(ParamMap param) {
        return customMapper.selectList(param);
    }

    @Override
    public Custom selectByCustomId(Long id) {
        return customMapper.selectByCustomId(id);
    }
}
