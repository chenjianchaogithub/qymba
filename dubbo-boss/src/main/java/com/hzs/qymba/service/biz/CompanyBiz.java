package com.hzs.qymba.service.biz;


import com.alibaba.dubbo.common.logger.Logger;
import com.alibaba.dubbo.common.logger.LoggerFactory;
import com.core.generic.GenericBiz;
import com.hzs.qymba.api.CompanyApi;
import com.hzs.qymba.dto.CompanyDTO;
import com.hzs.qymba.model.Company;
import com.hzs.qymba.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompanyBiz extends GenericBiz<CompanyDTO,Company> implements CompanyApi {

    private Logger logger = LoggerFactory.getLogger(CompanyBiz.class);

    @Autowired
    private CompanyService companyService;


    /**
     * 查询所有菜单
     * @return
     */
    @Override
    public List<CompanyDTO> selectAll() {
        List<Company> menuList = companyService.selectAll();//数据库数据
        List<CompanyDTO> companyDTOList = gsonList(menuList);


        /* for (Menu menu : menuList){
            MenuDTO menuDTO = new MenuDTO();

            menuDTOList.add(menuDTO);
        }*/
        return companyDTOList;
    }
}
