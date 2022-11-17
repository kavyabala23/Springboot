package com.example.Students.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Teachers {
    @Id
    @GeneratedValue
    private Long teach_id;
    private String name;
    private String email;
    private String mobile_num;
    private String address;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "dept_id", nullable = false)
//    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Departments departments;
//    constructors

    public Teachers(){

    }

    public Teachers(String name,String email,String mobile_num,String address,Departments departments) {
        this.name = name;
        this.email =email;
        this.mobile_num =mobile_num;
        this.address =address;
    }
    // getters and setters


    public Long getTeach_id() {
        return teach_id;
    }

    public void setTeach_id(Long teach_id) {
        this.teach_id = teach_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile_num() {
        return mobile_num;
    }

    public void setMobile_num(String mobile_num) {
        this.mobile_num = mobile_num;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Departments getDepartments() {
        return departments;
    }

    public void setDepartments(Departments departments) {
        this.departments = departments;
    }

    @Override
    public boolean equals(Object o){
        if(this==o) //to check current we use this
            return true;
        if(!(o instanceof Departments))
            return false;
        Teachers teacher =(Teachers) o;
        return Objects.equals(this.teach_id,teacher.teach_id);
    }
    //computes hash value(numeric value of fixed length) of given data
    @Override
    public int hashCode(){
        return Objects.hash(this.teach_id, this.name, this.email,this.mobile_num,this.address,this.departments);
    }
    @Override
    public String toString() {
        return "Teachers [id=" + teach_id + ", name=" + name + ", description=" + email+ "mobile number"+ mobile_num+"address"+address+"department id"+departments+"]";//"techers"+ teachersList+
    }

}
