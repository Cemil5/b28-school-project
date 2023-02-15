package com.cydeo.service;

import com.cydeo.database.Database;
import com.cydeo.entity.School;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import static com.cydeo.database.Database.schoolList;

public class SchoolServiceImpl implements CRUDService<School>{
    @Override
    public School findById(int id) {
        try{
            return schoolList.stream().filter(school -> school.getId() == id).findAny().orElseThrow();
        }catch(NoSuchElementException e){
            return new School();
        }
    }

    @Override
    public List<School> findAll() {
        return schoolList.stream().collect(Collectors.toList());
    }

    @Override
    public void save(School school) {
        schoolList.add(school);

    }

    @Override
    public void update(School school) {
        for (int i = 0; i < findAll().size(); i++) {
            if (findAll().get(i).getId() == school.id){
                findAll().set(i,school);
            }
        }
    }

    @Override
    public void deleteById(int id) {
        schoolList.removeIf(school -> school.getId() == id);

    }
}
