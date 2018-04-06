package com.hzs.qymba.service;

import com.hzs.qymba.bean.Student;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface StudentService {

    List<Student> listStudent();

}
