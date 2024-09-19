package com.BSP.StudentApis.Service;

import com.BSP.StudentApis.Entity.Students;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface StudentService {
    ResponseEntity<String> listofStudent(List<Students> st);

    List<Students> getAll();

    Students getid(int id);

    ResponseEntity<String> delid(int id);

    Students updStd(int id, Students students);

    Students addStd(Students students);
}
