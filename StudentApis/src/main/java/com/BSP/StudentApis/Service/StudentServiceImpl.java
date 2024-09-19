package com.BSP.StudentApis.Service;

import com.BSP.StudentApis.Entity.Students;
import com.BSP.StudentApis.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class StudentServiceImpl implements StudentService{

    private StudentRepository studentRepository;
    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public ResponseEntity<String> listofStudent(List<Students> st) {
        studentRepository.saveAll(st);
        return ResponseEntity.ok("Data Successfully added");
    }

    @Override
    public List<Students> getAll() {
        List<Students> students=studentRepository.findAll();
        return students;
    }

    @Override
    public Students getid(int id) {
        return studentRepository.findById(id).get();
    }

    @Override
    public ResponseEntity<String> delid(int id) {
        Students students=studentRepository.findById(id).get();
        studentRepository.delete(students);
        return ResponseEntity.ok("Deleted Successfully");
    }

    @Override
    public Students updStd(int id, Students students) {
       return studentRepository.findById(id).map(existinguser->{
                   if(Objects.nonNull(students.getRollno())){
                       existinguser.setRollno(students.getRollno());
                   }
                   if (Objects.nonNull(students.getDepartment())){
                       existinguser.setDepartment(students.getDepartment());
                   }
                   if (Objects.nonNull(students.getSection())){
                       existinguser.setSection(students.getSection());
                   }
                   if (Objects.nonNull(students.getMobileno())){
                       existinguser.setMobileno(students.getMobileno());
                   }
                   if (Objects.nonNull(students.getSubjects())){
                       existinguser.setSubjects(students.getSubjects());
                   }
                   if (Objects.nonNull(students.getStudentname())){
                       existinguser.setStudentname(students.getStudentname());
                   }
                   return studentRepository.save(existinguser);
       }).orElse(null);
    }

    @Override
    public Students addStd(Students students) {
        return studentRepository.save(students);
    }
}
