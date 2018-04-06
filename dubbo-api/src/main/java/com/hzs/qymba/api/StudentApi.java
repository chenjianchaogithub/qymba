package com.hzs.qymba.api;

import com.hzs.qymba.dto.StudentDTO;
import java.util.List;

public interface StudentApi {
    List<StudentDTO> listStudents();
}
