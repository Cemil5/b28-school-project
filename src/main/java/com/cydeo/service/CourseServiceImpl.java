package com.cydeo.service;

import com.cydeo.database.Database;
import com.cydeo.entity.Course;

import java.util.List;
import java.util.NoSuchElementException;

import static com.cydeo.database.Database.courseList;

public class CourseServiceImpl implements CRUDService<Course> {

    @Override
    public Course findById(int id) {

        return courseList.stream()
                .filter(course -> course.getId() == id)
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Provided course id: " + id + " is not in the database"));
    }

    @Override
    public List<Course> findAll() {
        return courseList;
    }

    @Override
    public void save(Course course) {
        courseList.add(course);

    }

    @Override
    public void update(Course course) {

        boolean idInTheDatabase = false;
        for (int i = 0; i < courseList.size(); i++) {
            if (courseList.get(i).getId() == course.getId()){
                courseList.set(i,course);
                idInTheDatabase = true;
            }

        }
        if (!idInTheDatabase)
            throw new NoSuchElementException("Provided course id: " + course.getId() + " is not in the database");

    }

    @Override
    public void deleteById(int id) {

        boolean idInTheDatabase = false;
        for (Course course : courseList) {
            if (course.getId() == id)
                Database.courseList.remove(course);
            idInTheDatabase = true;

        }
        if (!idInTheDatabase)
            throw new NoSuchElementException("Provided course id: " + id + " is not in the database");
    }

}
