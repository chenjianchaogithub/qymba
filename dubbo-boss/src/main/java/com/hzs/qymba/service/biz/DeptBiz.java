package com.hzs.qymba.service.biz;


import com.alibaba.dubbo.common.logger.Logger;
import com.alibaba.dubbo.common.logger.LoggerFactory;
import com.core.generic.GenericBiz;
import com.hzs.qymba.api.DeptApi;
import com.hzs.qymba.dto.DeptDTO;
import com.hzs.qymba.model.Dept;
import com.hzs.qymba.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptBiz extends GenericBiz<DeptDTO,Dept> implements DeptApi {

    private Logger logger = LoggerFactory.getLogger(DeptBiz.class);

    @Autowired
    private DeptService deptService;


    /**
     * 查询所有菜单
     * @return
     */
    @Override
    public List<DeptDTO> selectAll() {
        List<Dept> menuList = deptService.selectAll();//数据库数据
        List<DeptDTO> deptDTOList = gsonList(menuList);

        return deptDTOList;
    }
}
