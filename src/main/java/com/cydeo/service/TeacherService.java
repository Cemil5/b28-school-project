package com.cydeo.service;

import com.cydeo.entity.Teacher;

import java.util.List;
import java.util.NoSuchElementException;

import static com.cydeo.database.Database.teacherList;

public class TeacherService implements CRUDService<Teacher> {
    @Override
    public Teacher findById(int id) {
        return teacherList.stream()
                .filter(teacher -> teacher.getId() == id)
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Teacher with id (" + id + ") does not exist."));
    }

    @Override
    public List<Teacher> findAll() {
        return teacherList;
    }

    @Override
    public void save(Teacher teacher) {
        teacherList.add(teacher);
    }

    @Override
    public void update(Teacher teacher) {
        boolean updated = false;
        for (int i = 0; i < teacherList.size(); i++) {
            if (teacherList.get(i).getId() == teacher.getId()) {
                teacherList.set(i, teacher);
                updated = true;
            }
        }
        if (!updated) {
            throw new NoSuchElementException("Teacher with id (" + teacher.id + ") does not exist.");
        }
    }

    @Override
    public void deleteById(int id) {
        boolean isDeleted = teacherList.removeIf(school -> school.getId() == id);
        if (!isDeleted) {
            throw new NoSuchElementException("Teacher with id (" + id + ") does not exist.");
        }
    }
}
