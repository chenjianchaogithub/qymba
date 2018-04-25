package com.hzs.qymba.service;

import com.hzs.qymba.model.Company;
import com.hzs.qymba.model.Menu;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CompanyService {

    /**
     * 查询所有
     * @return
     */
    List<Company> selectAll();

}
