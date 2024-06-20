package com.duan.config;

import com.duan.interceptor.LoginIntercepote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    private LoginIntercepote loginCheckInterceptor;
 
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //定义拦截对象
        registry.addInterceptor(loginCheckInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/user/login");
    }
}