package com.qymba.service;

import com.qymba.bean.Student;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface StudentService {

    List<Student> listStudent();

}
