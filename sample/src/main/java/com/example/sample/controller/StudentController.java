package com.example.Students.controller;

import com.example.Students.entity.Student;
import com.example.Students.entity.Teachers;
import com.example.Students.exception.DepartmentNotFoundException;
import com.example.Students.repository.DepartmentRepository;
import com.example.Students.repository.TeachersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import com.example.Students.repository.StudentRepository;
public class StudentController {
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private StudentRepository studentsRepository;

    @GetMapping("/students")
    public List<Student> all() {
        return studentsRepository.findAll();
    }

    @GetMapping("/students/{id}")
    Student one(@PathVariable("id") Long id) {
        return studentsRepository.findById(id)
                .orElseThrow(() -> new DepartmentNotFoundException(id));


    }

    @PostMapping("/students")
    Student newStudents(Student newStudents){
        return studentsRepository.save(newStudents);
    }

    @PutMapping("/students/{id}")
    Student replaceStudents(@RequestBody Student newStudents, @PathVariable Long id){
        return studentsRepository.findById(id)
                //Map represents a mapping between a key and a value
                .map(Students ->{
                    Students.setName(Students.getName());
                    Students.setEmail(Students.getEmail());
                    Students.setMobile_num(Students.getMobile_num());
                    Students.setAddress(Students.getAddress());
                    return studentsRepository.save(Students);
                })
                .orElseGet(() ->{
                    newStudents.setStud_id(Long.valueOf(id.intValue()));
                    return studentsRepository.save(newStudents);
                });
    }
    @PatchMapping("/students/{id}")
    Student updateStudents(@RequestBody Student newStudents,@PathVariable Long id){
        Student user =studentsRepository.findById(id)
                .orElseThrow(() ->new DepartmentNotFoundException(id));
        user.setName(newStudents.getName());
        return studentsRepository.save(user);
    }
    @DeleteMapping("/teachers/{id}")
    void  deleteStudents(@PathVariable Long id) {
        studentsRepository.deleteById(id);

    }
}
