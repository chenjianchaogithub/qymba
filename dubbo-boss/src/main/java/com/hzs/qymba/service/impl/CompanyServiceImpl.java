package com.hzs.qymba.service.impl;

import com.hzs.qymba.mapper.CompanyMapper;
import com.hzs.qymba.mapper.MenuMapper;
import com.hzs.qymba.model.Company;
import com.hzs.qymba.model.Menu;
import com.hzs.qymba.service.CompanyService;
import com.hzs.qymba.service.MenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {
    @Resource
    private CompanyMapper companyMapper;


    @Override
    public List<Company> selectAll() {
        return companyMapper.selectAll();
    }
}
