package com.duan.interceptor;

import com.auth0.jwt.interfaces.Claim;
import com.duan.util.JwtUtils;
import com.duan.util.ThreadLocalUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Component
public class LoginIntercepoter implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //1,先获取请求头
        String token = request.getHeader("token");
        response.setContentType("application/json;charset = UTF-8");
        //2,判断请求头是否存在
        if (token == null || token.isEmpty()){
            //请求头不存在或者请求头为空
            return false;
        }
        //3,请求头不正确
        try {
            Map<String, Claim> verify = JwtUtils.verify(token);
            if(verify!=null){
                String userId = String.valueOf(verify.get("userId"));
                String username = String.valueOf(verify.get("username"));
                //id和username存到全局变量，之后的操作需要
                ThreadLocalUtil.set("userId",userId);
                ThreadLocalUtil.set("username",username);
            }

        }  catch (Exception e)  {
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }

}
