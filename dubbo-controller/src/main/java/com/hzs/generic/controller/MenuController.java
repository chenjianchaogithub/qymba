package com.hzs.generic.controller;

import com.core.generic.GenericController;
import com.core.regular.BaseRegular;
import com.hzs.qymba.api.MenuApi;
import com.hzs.qymba.dto.MenuDTO;
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
@RequestMapping("/menu")
public class MenuController extends GenericController {

    @Resource
    private MenuApi menuApi;
    /**
     * 列表界面
     *
     * @param model
     * @return
     */
    @RequestMapping("/list")
    public String index(Model model, HttpServletRequest request){
        System.out.println("list");
        return "menu/menu";
    }

    /**
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/ajax", method = RequestMethod.POST)
    public @ResponseBody
    Object ajax(HttpServletRequest request){
        Map<String,Object> map = new HashMap<String,Object>();
        ParamMap param = getParamMap(request);
        // 关键字拆分   pageSize、currentPage、page
        param.changeKeywords("keyword");
        List<MenuDTO> list = menuApi.selectAll();
        // 选择用于过滤该类型用户列表的视图类
        return  list;
        //return map;
    }
}
