package com.chen.controller;

import com.chen.entity.Department;
import com.chen.entity.Role;
import com.chen.entity.User;
import com.chen.service.IDepartmentService;
import com.chen.service.IRoleService;
import com.chen.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private IUserService userService;
    @Autowired
    private IDepartmentService departmentService;
    @Autowired
    private IRoleService roleService;


    @RequestMapping("findOne/{id}")
    public User findOne(@PathVariable Long id) {
        User user = userService.findOne(id);
        System.out.println(user);
        return user;
    }

    @RequestMapping("batchAdd/{number}")
    public void batchAdd(@PathVariable Integer number) {
        List<Department> departments = departmentService.getAllDepartments();
        List<Role> roles = roleService.getAllRoles();
        System.out.println("===============分割线================");
        System.out.println(departments);
        for (int i = 0; i < number; i++) {
            User user = new User();
            user.setCreateDate(new Date());
            user.setDepartment(departments.get(0));
            user.setName("张三"+i);
            user.setRoles(roles);
            userService.addOne(user);
        }
        System.out.println("end.............");
    }

    @RequestMapping("findAll")
    public List<User> findAll(){
        return  userService.findAll();
    }

    @RequestMapping("findByPage/{pageNum}")
    public List<User> findByPage(@PathVariable Integer pageNum){
        Pageable pageable = new PageRequest(pageNum,2);
        Page<User> page = userService.findByPage(pageable);
        return page.getContent();
    }

}
