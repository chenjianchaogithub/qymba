package com.hzs.qymba.controller;

import com.alibaba.dubbo.common.logger.Logger;
import com.alibaba.dubbo.common.logger.LoggerFactory;
import com.hzs.qymba.api.StudentApi;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;


@Controller
@RequestMapping("/student")
public class StudentController {
    private static Logger logger = LoggerFactory.getLogger(StudentController.class);

    @Resource
    private StudentApi studentApi;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addStudent(){
        logger.info("the data are " + studentApi.listStudents());
        return "student/index";
    }
}

