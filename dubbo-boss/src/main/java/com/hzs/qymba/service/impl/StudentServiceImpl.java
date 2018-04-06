package com.hzs.qymba.service.impl;

import com.hzs.qymba.bean.Student;
import com.hzs.qymba.mapper.StudentMapper;
import com.hzs.qymba.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Resource
    private StudentMapper studentMapper;

    //@Override
    public List<Student> listStudent() {
        //List<Student> listStudent = studentMapper.listStudent();
        List<Student> listStudent = new ArrayList<Student>();
        Student student = new Student();
        student.setId(1L);
        student.setAge(10);
        student.setName("测试");
        listStudent.add(student);
        return listStudent;
    }
}
