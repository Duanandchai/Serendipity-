package com.duan.controller;

import com.duan.pojo.AjaxResult;
import com.duan.service.UserService;
import com.duan.util.TenantKeyContext;
import com.duan.util.ThreadLocalUtil;
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

    @GetMapping("/a")
    public String test(){
        String username = ThreadLocalUtil.get("username");
        String userId = ThreadLocalUtil.get("id");
        return username+userId;
    }

}
