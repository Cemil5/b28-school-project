package com.cydeo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Teacher extends BaseEntity {

    private String firstName;
    private String lastName;

    private String phoneNumber;
    private BigDecimal salary;

    public Teacher(int id, String firstName, String lastName, String phoneNumber, BigDecimal salary) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
    }

}
