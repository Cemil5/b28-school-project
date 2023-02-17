package com.cydeo.service;

import com.cydeo.database.Database;
import com.cydeo.entity.Parent;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class ParentServiceImpl implements CRUDService<Parent> {
    @Override
    public Parent findById(int id) {

        return Database.parentList.stream().
                filter(p->p.getId()==id).findFirst()
                .orElseThrow(()->new NoSuchElementException("You dont have parent whis has this id"));
    }

    @Override
    public List<Parent> findAll() {

        return Database.parentList;
    }

    @Override
    public void save(Parent parent) {

        Database.parentList.add(parent);
    }

    @Override
    public void update(Parent parent) {
//        Parent[] arr=findAll().toArray(new Parent[0]);
//        int index=0;
//        for(int i=0;i<arr.length;i++){
//            if(parent.id==arr[i].getId()){
//                index=i;
//            }
//        }
//        arr[index]=parent;
        for (int i = 0; i < findAll().size(); i++) {
            if(parent.id==findAll().get(i).getId()){
                findAll().set(i,parent);
            }
        }

    }

    @Override
    public void deleteById(int id) {
        findAll().removeIf(p->p.getId()==id);
    }
}
