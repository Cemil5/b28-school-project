package com.cydeo.entity;

import com.cydeo.enums.WeekDays;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course extends BaseEntity{

    private String name;
    private int minScore;
    private List<WeekDays> courseDays;

    public Course(int id, String name, int minScore, List<WeekDays> courseDays) {
        super(id);
        this.name = name;
        this.minScore = minScore;
        this.courseDays = courseDays;
    }
}
