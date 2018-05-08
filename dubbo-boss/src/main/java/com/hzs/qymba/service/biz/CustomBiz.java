package com.hzs.qymba.service.biz;


import com.alibaba.dubbo.common.logger.Logger;
import com.alibaba.dubbo.common.logger.LoggerFactory;
import com.google.gson.Gson;
import com.hzs.qymba.api.CustomApi;
import com.hzs.qymba.dto.CustomDTO;
import com.hzs.qymba.model.Custom;
import com.hzs.qymba.service.CustomService;
import com.util.ParamMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CustomBiz implements CustomApi {

    private Logger logger = LoggerFactory.getLogger(CustomBiz.class);

    @Autowired
    private CustomService customService;


    @Override
    public List<CustomDTO> selectAll() {
        return gsonList(customService.selectAll());
    }

    @Override
    public Map<String, Object> selectPager(ParamMap param) {
        Map<String, Object> rs = new HashMap<String, Object>();
        // 统计总条数
        long total = customService.selectCount(param);
        // 翻页计算记录起始
        param.turnPage(total);
        // 获取结果
        rs.put("total", total);
        rs.put("rows", gsonList(customService.selectList(param)));
        return rs;
    }

    @Override
    public CustomDTO selectByCustomId(Long id) {
        return gsonObject(customService.selectByCustomId(id));
    }

    /**
     * 类型转换
     * @param customList
     * @return
     */
    private List<CustomDTO> gsonList(List<Custom> customList){
        List<CustomDTO> customDTOList = new ArrayList<CustomDTO>();
        Gson gs = new Gson();
        for (Custom custom:customList){
            String customStr = gs.toJson(custom);
            CustomDTO customDTO = gs.fromJson(customStr,CustomDTO.class);
            customDTOList.add(customDTO);
        }
        return customDTOList;
    }

    private CustomDTO gsonObject(Custom custom){
        Gson gs = new Gson();
        String customStr = gs.toJson(custom);
        CustomDTO customDTO = gs.fromJson(customStr,CustomDTO.class);
        return customDTO;
    }
}
