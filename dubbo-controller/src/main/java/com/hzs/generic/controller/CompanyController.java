package com.hzs.generic.controller;

import com.core.generic.GenericController;
import com.hzs.qymba.api.CompanyApi;
import com.hzs.qymba.api.MenuApi;
import com.hzs.qymba.dto.CompanyDTO;
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
@RequestMapping("/company")
public class CompanyController extends GenericController {

    @Resource
    private CompanyApi companyApi;
    /**
     * 列表界面
     *
     * @param model
     * @return
     */
    @RequestMapping("/list")
    public String index(Model model, HttpServletRequest request){
        System.out.println("list");
        return "company/list";
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
        List<CompanyDTO> list = companyApi.selectAll();

        // 选择用于过滤该类型用户列表的视图类
        return  list;
        //return map;
    }
}
