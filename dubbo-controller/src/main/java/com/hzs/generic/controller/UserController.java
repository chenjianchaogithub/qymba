package com.hzs.generic.controller;

import com.alibaba.dubbo.common.logger.Logger;
import com.alibaba.dubbo.common.logger.LoggerFactory;
import com.core.generic.GenericController;
import com.core.regular.BaseRegular;
import com.hzs.qymba.api.UserApi;
import com.hzs.qymba.controller.GlobalController;
import com.hzs.qymba.dto.UserDTO;
import com.util.ParamMap;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController extends GenericController{

    private static Logger logger = LoggerFactory.getLogger(UserController.class);


    @Resource
    private UserApi userApi;
    /**
     * 列表界面
     *
     * @param model
     * @return
     */
    @RequestMapping("/list")
    public String list(Model model, HttpServletRequest request){
        System.out.println("list");
        List<UserDTO> list = userApi.selectAll();
        return "user/list";
    }

    /**
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/ajax", method = RequestMethod.POST)
    public @ResponseBody Object ajax(HttpServletRequest request){
        Map<String,Object> map = new HashMap<String,Object>();
        ParamMap param = getParamMap(request);
        // 关键字拆分
        param.changeKeywords("keyword");

        List<UserDTO> list = userApi.selectAll();
        map.put("draw", 1);
        map.put("recordsTotal", list.size());
        map.put("recordsFiltered", list.size());
        map.put("data", list );

        // 选择用于过滤该类型用户列表的视图类
        return  jsonView(map,BaseRegular.BaseList.class);
        //return map;
    }
}
