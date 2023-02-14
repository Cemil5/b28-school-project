package com.cydeo;

import com.cydeo.database.Database;

public class SchoolMainRunner {

//    public static CRUDService<School> schoolService;
//    public static CRUDService<Course> courseService;
//    public static CRUDService<Parent> parentService;
//    public static CRUDService<Student> studentService;
//
//    static {
//        SchoolMainRunner.schoolService = new SchoolService();
//        SchoolMainRunner.courseService = new CourseService();
//        SchoolMainRunner.parentService = new ParentService();
//        SchoolMainRunner.studentService = new StudentService();
//    }

    public static void main(String[] args) {

        Database.courseList.forEach(System.out::println);

    }


}
