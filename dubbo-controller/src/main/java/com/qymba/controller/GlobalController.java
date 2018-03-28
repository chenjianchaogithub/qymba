package com.qymba.controller;

import com.alibaba.dubbo.common.logger.Logger;
import com.alibaba.dubbo.common.logger.LoggerFactory;
import com.qymba.api.StudentApi;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/")
public class GlobalController {

    private static Logger logger = LoggerFactory.getLogger(GlobalController.class);

    /**
     * 重新登录
     *
     * @return
     */
    @RequestMapping(value = "relogin", method = RequestMethod.GET)
    public String relogin(Model model)  {
        //onlineManager.logout(); // 在控制器中注销
        model.addAttribute("warning","user.login.relogin");
        return "login";
    }

    /**
     * 不接受get
     *
     * @return
     */
    @RequestMapping(value = "checkin", method = RequestMethod.GET)
    public String checkin(HttpServletRequest request){
        /*if (isAjax(request))
            throw new OperationException("非法操作");*/
        return "redirect:/index.html";
    }

    /**
     * 主程序界面
     *
     * @param model
     * @return
     */
    @RequestMapping("index")
    public String index(Model model, HttpServletRequest request){
        // Verify.init().check();

        /*if (Mobile.is(request)) {
            if (WeixinUtil.isWx(request))
                return "redirect:" + WeixinUtil.getOauthUrl();
            else
                return "redirect:/mobile";
        }*/

       /* if (isAjax(request))
            throw new OperationException("登陆超时，请重新登陆！");*/

        return "index";
    }
}
