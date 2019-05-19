package com.chen;


import com.chen.config.MyConfiguration;
import com.chen.entity.Student;
import com.chen.entity.Teacher;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfiguration.class);
        System.out.println("-----------------------------");
        Student student = context.getBean(Student.class);
        System.out.println(student);

        Teacher teacher = context.getBean(Teacher.class);
        System.out.println(teacher);

    }
}
