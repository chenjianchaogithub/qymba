package com.hzs.qymba.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * Created with IDEA
 * author:chenjianchao
 * Date:2018/3/27
 * Time:09:30
 *
 * */

@Controller
@RequestMapping("/work")
public class WorkController {

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(Model model)  {
        //onlineManager.logout(); // 在控制器中注销
        model.addAttribute("warning","user.login.relogin");
        return "work/index";
    }

    @RequestMapping(value = "/demo", method = RequestMethod.GET)
    public String relogin(Model model)  {
        //onlineManager.logout(); // 在控制器中注销
        model.addAttribute("warning","user.login.relogin");
        return "work/demo";
    }

}
