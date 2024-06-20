package com.duan.controller;

import com.duan.pojo.AjaxResult;
import com.duan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public AjaxResult Login(String username, String password){
        return userService.login(username,password);
    }
}
