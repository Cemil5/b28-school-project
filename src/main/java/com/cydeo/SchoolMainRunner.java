package com.cydeo;

import com.cydeo.database.Database;
import com.cydeo.entity.*;
import com.cydeo.service.CRUDService;
import com.cydeo.service.TeacherService;

public class SchoolMainRunner {

    public static CRUDService<School> schoolService;
    public static CRUDService<Course> courseService;
    public static CRUDService<Parent> parentService;
    public static CRUDService<Student> studentService;
    public static CRUDService<Teacher> teacherService;

    static {
//        SchoolMainRunner.schoolService = new SchoolService();
//        SchoolMainRunner.courseService = new CourseService();
//        SchoolMainRunner.parentService = new ParentService();
//        SchoolMainRunner.studentService = new StudentService();
        teacherService = new TeacherService();
    }

    public static void main(String[] args) {
        try {
            System.out.println(teacherService.findById(3));

        } catch (Exception e){
            System.out.println(e.getMessage());
        }

    }


}
