package com.hzs.qymba.service.impl;

import com.hzs.qymba.mapper.CompanyMapper;
import com.hzs.qymba.mapper.DeptMapper;
import com.hzs.qymba.model.Company;
import com.hzs.qymba.model.Dept;
import com.hzs.qymba.service.CompanyService;
import com.hzs.qymba.service.DeptService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {
    @Resource
    private DeptMapper deptMapper;


    @Override
    public List<Dept> selectAll() {
        return deptMapper.selectAll();
    }
}
