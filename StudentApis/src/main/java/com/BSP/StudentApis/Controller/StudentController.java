package com.BSP.StudentApis.Controller;

import com.BSP.StudentApis.Entity.Students;
import com.BSP.StudentApis.Service.StudentService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;


@RestController
@RequestMapping("/v1")
public class StudentController {
    public static final Logger LOGGER= (Logger) LoggerFactory.getLogger(StudentController.class);
    private StudentService studentService;
    @Autowired
    public StudentController(StudentService studentService){
        this.studentService=studentService;
    }
    @PostMapping("/list")
    public ResponseEntity<String> listofStudent(@RequestBody List<Students> st){
        LOGGER.info("Storing list of student data");
        return studentService.listofStudent(st);
    }

    @GetMapping("/get")
    public List<Students> getAll(){
        LOGGER.info("Getting all Student data");
        return studentService.getAll();
    }

    @GetMapping("/get/{id}")
    public Students getid(@PathVariable int id){
        LOGGER.info("Getting Student data with id: {}",id);
        return studentService.getid(id);
    }

    @DeleteMapping("/del/{id}")
    public ResponseEntity<String> delid(@PathVariable int id){
        LOGGER.info("Deleting Student data with id: {}",id);
        return studentService.delid(id);
    }

    @PutMapping("/upd/{id}")
    public Students updStd(@PathVariable int id,@RequestBody Students students){
        LOGGER.info("Updating Student data with id: {}",id);
        return studentService.updStd(id,students);
    }

    @PostMapping("/add")
    public Students addStd(@RequestBody Students students){
        LOGGER.info("Adding new Student data to Database: {}",students);
        return studentService.addStd(students);
    }
}
