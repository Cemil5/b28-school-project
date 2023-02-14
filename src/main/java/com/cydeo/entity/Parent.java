package com.cydeo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Parent extends BaseEntity {

    private String firstName;
    private String lastName;
    private String phoneNumber;

    public Parent(int id, String firstName, String lastName, String phoneNumber) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }
}
