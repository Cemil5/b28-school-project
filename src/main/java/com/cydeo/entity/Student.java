package com.cydeo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student  extends BaseEntity{

    private Long studentNumber;
    private String firstName;
    private String lastName;
    private Parent parent;
    private List<Course> courses;

    public Student(int id, Long studentNumber, String firstName, String lastName, Parent parent, List<Course> courses) {
        super(id);
        this.studentNumber = studentNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.parent = parent;
        this.courses = courses;
    }
}
