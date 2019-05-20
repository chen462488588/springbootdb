package com.chen;

import com.chen.entity.User;
import com.chen.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MysqlApplicationTest {
    @Autowired
    private IUserService userService;
    @Test
    public void contextLoads() {
    }

    @Test
    public void testRepository(){
//        List<User> users = userService.findAll();
//        System.out.println(users);
//        Assert.isNull(users);
        User user = userService.findOne(34L);
        System.out.println("user:"+user);
    }
}
