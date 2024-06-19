package com.duan.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.duan.mapper.UserMapper;
import com.duan.pojo.User;
import com.duan.service.UserService;
import com.duan.util.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>implements UserService {
    @Autowired
    UserMapper userMapper;
    //JWT登录，返回token令牌
    public String login(String username, String password) {
        //根据用户名查询库中是否有该用户
        User user = userMapper.selectByUserName(username);
        //密码对比
        if (user!=null&&user.getPassword().equals(password)){
            //查询到用户，并且密码正确  生成JWT令牌
            return JwtUtils.getJwt(user.getId(), username);
        }
        return "用户名或密码错误";
    }
}
