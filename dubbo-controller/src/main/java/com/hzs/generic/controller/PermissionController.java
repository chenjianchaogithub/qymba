package com.hzs.generic.controller;

import com.alibaba.dubbo.common.logger.Logger;
import com.alibaba.dubbo.common.logger.LoggerFactory;
import com.core.generic.GenericController;
import com.core.regular.BaseRegular;
import com.hzs.qymba.api.PermissionApi;
import com.util.ParamMap;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/permission")
public class PermissionController extends GenericController{

    private static Logger logger = LoggerFactory.getLogger(PermissionController.class);


    @Resource
    private PermissionApi permissionApi;
    /**
     * 列表界面
     *
     * @param model
     * @return*/

    @RequestMapping("/list")
    public String list(Model model, HttpServletRequest request){
        return "permission/list";
    }

    /**
     *
     * @param request
     * @return*/

    @RequestMapping(value = "/ajax", method = RequestMethod.POST)
    public @ResponseBody Object ajax(HttpServletRequest request){
        Map<String,Object> map = new HashMap<String,Object>();
        ParamMap param = getParamMap(request);
        // 关键字拆分   pageSize、currentPage、page
        param.changeKeywords("keyword");

        // 选择用于过滤该类型用户列表的视图类
        return  jsonView(permissionApi.selectPager(param),BaseRegular.BaseList.class);
        //return map;
    }

}
