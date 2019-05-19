package com.chen;

import com.chen.config.JpaConfiguration;
import com.chen.dao.DepartmentRepository;
import com.chen.dao.RoleRepository;
import com.chen.dao.UserRepository;
import com.chen.entity.Department;
import com.chen.entity.Role;
import com.chen.entity.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {JpaConfiguration.class})
public class MysqlTest {

  @Autowired
   UserRepository userRepository;

  @Autowired
   RoleRepository roleRepository;

  @Autowired
   DepartmentRepository departmentRepository;

  @Before
   public void initData(){
     userRepository.deleteAll();
     roleRepository.deleteAll();
     departmentRepository.deleteAll();

     Department department = new Department();
     department.setName("销售部");
     departmentRepository.save(department);
     Assert.notNull(department.getId());

     Role role = new Role();
     role.setName("admin");
     roleRepository.save(role);
     Assert.notNull(role.getId());

     User user = new User();
     user.setCreateDate(new Date());
     user.setDepartment(department);
     user.setName("陈坤");

     List<Role> roles = roleRepository.findAll();
     Assert.notNull(roles);
     user.setRoles(roles);
     userRepository.save(user);
      Assert.notNull(user.getId());

  }

  @Test
  public void findPage(){
    Pageable pageable = new PageRequest(0,10,new Sort(Sort.Direction.ASC,"id"));
    Page<User> page = userRepository.findAll(pageable);
    Assert.notNull(page);
    for(User user : page.getContent()){
      System.out.println(user);
    }
  }

}
