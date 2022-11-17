package com.example.Students.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Student {

        @Id
        @GeneratedValue
        private Long stud_id;
        private String name;
        private String email;
        private String mobile_num;
        private String address;
//    constructors

        public Student(){

        }

        public Student(String name,String email,String mobile_num,String address) {
            this.name = name;
            this.email =email;
            this.mobile_num =mobile_num;
            this.address =address;
        }
        // getters and setters


        public Long getStud_id() {
            return stud_id;
        }

        public void setStud_id(Long stud_id) {
            this.stud_id = stud_id;
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

        @Override
        public boolean equals(Object o){
            if(this==o) //to check current we use this
                return true;
            if(!(o instanceof Departments))
                return false;
           Student student=(Student) o;
            return Objects.equals(this.stud_id,student.stud_id);
        }
        //computes hash value(numeric value of fixed length) of given data
        @Override
        public int hashCode(){
            return Objects.hash(this.stud_id, this.name, this.email,this.mobile_num,this.address);
        }
        @Override
        public String toString() {
            return "Students [id=" + stud_id + ", name=" + name + ", description=" + email+ "mobile number"+ mobile_num+"address"+address+"]";
        }

    }
