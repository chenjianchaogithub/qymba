package com.hzs.qymba.service.biz;


import com.alibaba.dubbo.common.logger.Logger;
import com.alibaba.dubbo.common.logger.LoggerFactory;
import com.core.generic.GenericBiz;
import com.hzs.qymba.api.AmibaApi;
import com.hzs.qymba.dto.AmibaDTO;
import com.hzs.qymba.model.Amiba;
import com.hzs.qymba.service.AmibaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AmibaBiz extends GenericBiz<AmibaDTO,Amiba> implements AmibaApi {

    private Logger logger = LoggerFactory.getLogger(AmibaBiz.class);

    @Autowired
    private AmibaService amibaService;


    /**
     * 查询所有菜单
     * @return
     */
    @Override
    public List<AmibaDTO> selectAll() {
        List<Amiba> menuList = amibaService.selectAll();//数据库数据
        List<AmibaDTO> amibaDTOList = gsonList(menuList);

        return amibaDTOList;
    }
}
