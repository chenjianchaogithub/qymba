package com.hzs.qymba.service.impl;

import com.hzs.qymba.mapper.AmibaMapper;
import com.hzs.qymba.mapper.DeptMapper;
import com.hzs.qymba.model.Amiba;
import com.hzs.qymba.model.Dept;
import com.hzs.qymba.service.AmibaService;
import com.hzs.qymba.service.DeptService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AmibaServiceImpl implements AmibaService {
    @Resource
    private AmibaMapper amibaMapper;


    @Override
    public List<Amiba> selectAll() {
        return amibaMapper.selectAll();
    }
}
