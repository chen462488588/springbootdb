package com.chen;

import com.chen.entity.User;
import com.chen.service.impl.UserServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

import java.util.List;

@SpringBootApplication
@ServletComponentScan
//@SpringBootConfiguration
//@EnableAutoConfiguration
//@ComponentScan(excludeFilters = @ComponentScan.Filter(type = FilterType.CUSTOM, classes = TypeExcludeFilter.class))
public class MysqlApplication {

    //        @Test
//        public void testSendMail(){
//            List<User> user = new UserServiceImpl().findAll();
//            sendMailService.sendMail(user);
//        }
    public static void main(String[] args) {
        List<User> user = new UserServiceImpl().findAll();

        SpringApplication.run(MysqlApplication.class, args);
        System.out.println(222);
        Logger logger =  LogManager.getLogger(MysqlApplication.class);
        logger.warn("warn..........");
        logger.error("error.......");
        logger.debug("debug........");

    }

}
