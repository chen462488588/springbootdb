package com.chen.controller;

import com.chen.entity.User;
import com.chen.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("hello")
public class HelloController {

    @Resource
    private IUserService userService;

    @RequestMapping("test")
    public String test(Model model){
        User user = userService.findOne(34L);
        model.addAttribute("user",user);
        return "hello";
    }
}
