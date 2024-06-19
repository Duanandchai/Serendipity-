package com.duan.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.duan.pojo.User;

public interface UserMapper extends BaseMapper<User> {
    User selectByUserName(String username);
}
