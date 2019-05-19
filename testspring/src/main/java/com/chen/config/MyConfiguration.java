package com.chen.config;

import com.chen.entity.Address;
import com.chen.entity.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.**.entity"})
public class MyConfiguration {
    public MyConfiguration() {
        System.out.println(this.getClass().getName() + ":初始化");
    }

    @Bean(name = "student")
    public Student student(Address address){

        return new Student(1,"zhangsan",address);
    }
}
