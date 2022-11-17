package com.example.Students.controller;

import com.example.Students.entity.Departments;
import com.example.Students.exception.DepartmentNotFoundException;
import com.example.Students.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;

//RestController is used for making restful web services with the help of the @RestController annotation. This annotation is used at the class level and allows the class to handle the requests made by the client.
@RestController
public class DepartmentController {
        @Autowired
        DepartmentRepository departmentRepository;

        @GetMapping("/departments")
         public List<Departments> all() {
            return departmentRepository.findAll();
        }

        @GetMapping("/departments/{id}")
        Departments one(@PathVariable("id") Long id) {
            return departmentRepository.findById(id)
                    .orElseThrow(() -> new DepartmentNotFoundException(id));


        }

        @PostMapping("/departments")
       Departments newDepartments(Departments newDepartments){
              return departmentRepository.save(newDepartments);
        }

        @PutMapping("/departments/{id}")
            Departments replaceDepartments(@RequestBody Departments newDepartments,@PathVariable Long id){
                return departmentRepository.findById(id)
                        //Map represents a mapping between a key and a value
                        .map(Departments ->{
                            Departments.setName(Departments.getName());
                            Departments.setDescription(Departments.getDescription());
                            return departmentRepository.save(Departments);
                        })
                        .orElseGet(() ->{
                            newDepartments.setId(Long.valueOf(id.intValue()));
                            return departmentRepository.save(newDepartments);
                        });
        }
        @PatchMapping("/departments/{id}")
        Departments updateDepartments(@RequestBody Departments newDepartments,@PathVariable Long id){
            Departments user =departmentRepository.findById(id)
                    .orElseThrow(() ->new DepartmentNotFoundException(id));
            user.setName(newDepartments.getName());
            return departmentRepository.save(user);
        }
        @DeleteMapping("/departments/{id}")
        void  deleteDepartments(@PathVariable Long id) {
             departmentRepository.deleteById(id);

        }
    }

