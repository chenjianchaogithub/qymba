package com.qymba.api;

import com.qymba.dto.StudentDTO;
import java.util.List;

public interface StudentApi {
    List<StudentDTO> listStudents();
}
