package com.chen;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
//@SpringBootConfiguration
//@EnableAutoConfiguration
//@ComponentScan(excludeFilters = @ComponentScan.Filter(type = FilterType.CUSTOM, classes = TypeExcludeFilter.class))
public class MysqlApplication {


    public static void main(String[] args) {
        SpringApplication.run(MysqlApplication.class, args);
        System.out.println(222);
        Logger logger =  LogManager.getLogger(MysqlApplication.class);
        logger.warn("warn..........");
        logger.error("error.......");
        logger.debug("debug........");

    }

}
