package com.hzs.qymba.mapper;

import com.hzs.qymba.model.Company;

import java.util.List;

public interface CompanyMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Company record);

    int insertSelective(Company record);

    Company selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Company record);

    int updateByPrimaryKey(Company record);


    /**
     * 查询所有
     * @return
     */
    List<Company> selectAll();
}