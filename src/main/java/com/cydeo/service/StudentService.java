package com.cydeo.service;

import com.cydeo.entity.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import static com.cydeo.database.Database.studentList;

public class StudentService implements CRUDService<Student> {


    @Override
    public Student findById(int id) {
        return studentList.stream()
                .filter(student -> student.getId() == id).findAny()
                .orElseThrow(() -> new NoSuchElementException("No student with id: "+id));
    }

    @Override
    public List<Student> findAll() {
        return new ArrayList<>(studentList);
    }

    @Override
    public void save(Student student) {
        studentList.add(student);
    }

    @Override
    public void update(Student student) {
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getId() == student.id){
                studentList.set(i,student);
            }
        }
    }

    @Override
    public void deleteById(int id) {
        studentList.removeIf(p -> p.getId() == id);
    }
}
