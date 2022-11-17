package com.example.Students.repository;
import com.example.Students.entity.Departments;



 import org.springframework.data.jpa.repository.JpaRepository;


public interface DepartmentRepository extends JpaRepository<Departments,Long> {

}
