package com.chen;

import com.chen.config.RedisConfig;
import com.chen.dao.UserRedis;
import com.chen.entity.Department;
import com.chen.entity.Role;
import com.chen.entity.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {UserRedis.class, RedisConfig.class})
public class RedisTest {
    private static Logger logger = LoggerFactory.getLogger(RedisTest.class);
    @Autowired
    UserRedis userRedis;

    @Before
    public void setup() {
        Department department = new Department();
        department.setName("测试部");

        Role role1 = new Role();
        role1.setName("ordinary");
        Role role2 = new Role();
        role2.setName("superuser");


        List<Role> roles = new ArrayList<>();
        roles.add(role1);
        roles.add(role2);

        User user = new User();
        user.setCreateDate(new Date());
        user.setRoles(roles);
        user.setName("chenkun");

        userRedis.delete(this.getClass().getName() + ":userByName:" + user.getName());
        userRedis.add(this.getClass().getName() + ":userByName:" + user.getName(), 10L, user);

    }

    @Test
    public void get() {
        String name = "chenkun";
        User user1 = userRedis.get(this.getClass().getName() + ":userByName:" + name);
        System.out.println(user1);
    }

}
