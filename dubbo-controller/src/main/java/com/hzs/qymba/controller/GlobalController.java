package com.hzs.qymba.controller;

import com.alibaba.dubbo.common.logger.Logger;
import com.alibaba.dubbo.common.logger.LoggerFactory;
import com.hzs.qymba.api.UserApi;
import com.hzs.qymba.model.LoginToken;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

@Controller
@RequestMapping("/")
public class GlobalController {

    private static Logger logger = LoggerFactory.getLogger(GlobalController.class);


    @Resource
    private UserApi userApi;
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
     * 判断是否已登录
     *
     * @return
     */
    @RequestMapping("login")
    @ResponseBody
    public Object login(HttpServletRequest request) {
        Map<String, Object> rs = new WeakHashMap<String, Object>();
        //boolean login = Online.hasLogin();
        // 是否已登录
        rs.put("login", true);
        // 如果未登录的是否要求验证码
        /*if (!login)
            rs.put("chkcode", RandomCreater.mustCheckCode(request));*/
        return rs;
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
     * 用户登录，身份验证
     *
     * @param token
     *            登录身份信息
     * @param result
     *            信息验证结果
     * @param model
     *            返回信息集
     * @param request
     * @return
     */
    @RequestMapping(value = "checkin", method = RequestMethod.POST)
    @ResponseBody
    public Object checkin( LoginToken token,
                          BindingResult result, Model model, HttpServletRequest request) {
        // 缺少必填的信息直接返回到登录表单页面
        HashMap data = new HashMap();
        data.put("status","0");
        if (result.hasErrors()) {
            data.put("error", result);
            data.put("status", "7000");//提交参数异常
            return data;
        }
        try {
            // 尝试身份验证
            SecurityUtils.getSubject().login(token);

        } catch (AuthenticationException e) { // 身份验证失败
            data.put("error","服务器出错");
            data.put("status", "7001");
            return data;
        }
        data.put("msg","登陆成功");
        return data;
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
