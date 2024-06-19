package com.duan.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.duan.mapper.UserMapper;
import com.duan.pojo.User;
import com.duan.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>implements UserService {
    //JWT登录，返回token令牌
    public String login(String username, String password) {
        //根据用户名查询库中是否有该用户
        //密码对比
        //密码正确生成JWT并返回
        return "";
    }
}
