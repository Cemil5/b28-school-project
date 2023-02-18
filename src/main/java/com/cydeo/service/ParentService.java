package com.cydeo.service;

import com.cydeo.database.Database;
import com.cydeo.entity.Parent;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class ParentService implements CRUDService<Parent> {
    private List<Parent> parentList = Database.parentList;

   /* @Override
    public Parent findById(int id) {
        for (Parent parent : parentList) { //throw exception
            if (parent.getId() == id) {
                return parent;
            }
        }
        return null;
    }*/

    @Override
public Parent findById(int id) {
    return parentList.stream()
        .filter(parent -> parent.getId() == id)
        .findFirst()
        .orElseThrow(()-> new NoSuchElementException("There's no parent associated with that ID."));
}

    @Override
    public List<Parent> findAll() {
        return new ArrayList<>(parentList);
    }

    @Override
    public void save(Parent parent) {
        parentList.add(parent);
    }

    @Override
    public void update(Parent parent) {
        for (int i = 0; i < parentList.size(); i++) {
            if (parentList.get(i).getId() == parent.getId()) {
                parentList.set(i, parent);
                return;
            }
        }
    }

    @Override
    public void deleteById(int id) {
        parentList.removeIf(parent -> parent.getId() == id);
    }
}
