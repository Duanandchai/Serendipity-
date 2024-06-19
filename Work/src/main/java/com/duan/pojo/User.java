package com.duan.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {
    private int id;
    private String username;
    private String password;
}
