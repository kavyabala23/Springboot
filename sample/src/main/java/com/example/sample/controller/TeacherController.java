package com.example.Students.controller;

import com.example.Students.entity.Departments;
import com.example.Students.entity.Teachers;
import com.example.Students.exception.DepartmentNotFoundException;
import com.example.Students.repository.DepartmentRepository;
import com.example.Students.repository.TeachersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class TeacherController {
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private TeachersRepository teachersRepository;

    @GetMapping("/teachers")
    public List<Teachers> all() {
        return teachersRepository.findAll();
    }

    @GetMapping("/teachers/{id}")
    Teachers one(@PathVariable("id") Long id) {
        return teachersRepository.findById(id)
                .orElseThrow(() -> new DepartmentNotFoundException(id));


    }

    @PostMapping("/teachers")
    Teachers newTeachers(Teachers newTeachers){
        return teachersRepository.save(newTeachers);
    }

    @PutMapping("/teachers/{id}")
    Teachers replaceTeachers(@RequestBody Teachers newTeachers, @PathVariable Long id){
        return teachersRepository.findById(id)
                //Map represents a mapping between a key and a value
                .map(Teachers ->{
                    Teachers.setName(Teachers.getName());
                    Teachers.setEmail(Teachers.getEmail());
                    Teachers.setMobile_num(Teachers.getMobile_num());
                    Teachers.setAddress(Teachers.getAddress());
                    return teachersRepository.save(Teachers);
                })
                .orElseGet(() ->{
                    newTeachers.setTeach_id(Long.valueOf(id.intValue()));
                    return teachersRepository.save(newTeachers);
                });
    }
    @PatchMapping("/teachers/{id}")
    Teachers updateTeachers(@RequestBody Teachers newTeachers,@PathVariable Long id){
        Teachers user =teachersRepository.findById(id)
                .orElseThrow(() ->new DepartmentNotFoundException(id));
        user.setName(newTeachers.getName());
        return teachersRepository.save(user);
    }
    @DeleteMapping("/teachers/{id}")
    void  deleteTeacher(@PathVariable Long id) {
        teachersRepository.deleteById(id);

    }
}
