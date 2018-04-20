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
import org.springframework.web.bind.annotation.PathVariable;
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
        // 关键字拆分   pageSize、currentPage、page
        param.changeKeywords("keyword");

        // 选择用于过滤该类型用户列表的视图类
        return  jsonView(userApi.selectPager(param),BaseRegular.BaseList.class);
        //return map;
    }

    /**
     * 新增界面
     *
     * @param model
     * @return
     */
    @RequestMapping("/add")
    public String add(Model model, HttpServletRequest request){
        return "user/add";
    }



    @RequestMapping(value = "/info/{id}", method = RequestMethod.POST)
    public @ResponseBody Object info(@PathVariable("id") Long id){
        UserDTO userDTO =  userApi.selectByUserId(id);
        return userApi.selectByUserId(id);
    }
}
