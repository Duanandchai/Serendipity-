package com.duan.controller;

import com.duan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    public String Login(String username,String password){

        return userService.login(username,password);
    }
}