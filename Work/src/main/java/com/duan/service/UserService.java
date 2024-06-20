package com.duan.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.duan.mapper.UserMapper;
import com.duan.pojo.AjaxResult;
import com.duan.pojo.User;

public interface UserService extends IService<User> {
    AjaxResult login(String username, String password);
}
