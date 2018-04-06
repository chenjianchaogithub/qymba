package com.hzs.qymba.service.biz;


import com.alibaba.dubbo.common.logger.Logger;
import com.alibaba.dubbo.common.logger.LoggerFactory;
import com.hzs.qymba.api.StudentApi;
import com.hzs.qymba.bean.Student;
import com.hzs.qymba.dto.StudentDTO;
import com.hzs.qymba.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentBiz  implements StudentApi {

    private Logger logger = LoggerFactory.getLogger(StudentBiz.class);

    @Autowired
    private StudentService studentService;

    @Override
    public List<StudentDTO> listStudents(){
        List<Student> listStudent = studentService.listStudent();
        List<StudentDTO> listStudentDTO = new ArrayList();
        for(Student student: listStudent){
            StudentDTO studentDTO = new StudentDTO();
            studentDTO.setId(student.getId());
            studentDTO.setAge(student.getAge());
            studentDTO.setName(student.getName());
            listStudentDTO.add(studentDTO);
        }
        return listStudentDTO;
    }
}
