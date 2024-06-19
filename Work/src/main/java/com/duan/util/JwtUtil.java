package com.duan.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtUtil {

    public static String getJwt(int id,String username){
        //获取jwt生成器
        JWTCreator.Builder jwtBuilder = JWT.create();
        //由于该生成器设置Header的参数为一个<String, Object>的Map,
        //所以我们提前准备好
        Map<String, Object> headers = new HashMap<>();
        headers.put("typ", "jwt");   //设置token的type为jwt
        headers.put("alg", "hs256");  //表明加密的算法为HS256
        //开始生成token
        //我们将之前准备好的header设置进去
        //token生成完毕，可以发送给客户端了，前端可以使用
        //下次请求时携带发送给服务器端进行验证
        return jwtBuilder.withHeader(headers)
                //接下来为设置PayLoad,Claim中的键值对可自定义
                //设置用户名
                .withClaim("username", username)
                //设置用户id
                .withClaim("userId", id)
                //token失效时间，这里为一天后失效
                .withExpiresAt(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24))
                //设置该jwt的发行时间，一般为当前系统时间
                .withIssuedAt(new Date(System.currentTimeMillis()))
                //token的发行者（可自定义）
                .withIssuer("issuer")
                //进行签名，选择加密算法，以一个字符串密钥为参数
                .sign(Algorithm.HMAC256("KEY"));
    }
}
