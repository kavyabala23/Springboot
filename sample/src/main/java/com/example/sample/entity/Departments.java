package com.example.Students.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name="department")
public class Departments {
    @Id
    @GeneratedValue
    public Long id;
    private String name;
    private String description;
//    constructors

    public Departments(){

    }

    public Departments(String name,String description) {
        this.name = name;
        this.description =description;
    }
// getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    @Override
    public boolean equals(Object o){
        if(this==o) //to check current we use this
            return true;
        if(!(o instanceof Departments))
            return false;
        Departments department =(Departments) o;
        return Objects.equals(this.id,department.id);
    }
    //computes hash value(numeric value of fixed length) of given data
    @Override
    public int hashCode(){
        return Objects.hash(this.id, this.name, this.description);
    }
    @Override
    public String toString() {
        return "Department [id=" + id + ", name=" + name + ", description=" + description + "]";//"techers"+ teachersList+
    }

}
