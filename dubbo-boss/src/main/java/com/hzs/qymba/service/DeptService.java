package com.hzs.qymba.service;

import com.hzs.qymba.model.Dept;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DeptService {

    /**
     * 查询所有
     * @return
     */
    List<Dept> selectAll();

}
