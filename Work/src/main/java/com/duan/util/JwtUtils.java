package com.duan.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.var;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtUtils {

    //生成JWT令牌 payload存放用户名id和name
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

    public static Map<String, Claim> verify(String token){
         /*获取jwt的验证器对象，传入的算法参数以及密钥字符串（KEY）必须
        和加密时的相同*/
        var require = JWT.require(Algorithm.HMAC256("KEY")).build();
        DecodedJWT decode;
        try {
            /*开始进行验证，该函数会验证此token是否遭到修改，
                以及是否过期，验证成功会生成一个解码对象
                ，如果token遭到修改或已过期就会
                抛出异常，我们用try-catch抓一下*/
            decode = require.verify(token);
        } catch (Exception e) {
            return null;
            //抛出异常，验证失败
        }
        //若验证成功，就可获取其携带的信息进行其他操作
        //可以一次性获取所有的自定义参数，返回Map集合
        return decode.getClaims();
    }

    public static void main(String[] args) {
        Map<String, Claim> verify = verify("eyJ0eXAiOiJqd3QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJpc3N1ZXIiLCJleHAiOjE3MTg5MzQ1ODIsInVzZXJJZCI6MSwiaWF0IjoxNzE4ODQ4MTgyLCJ1c2VybmFtZSI6InpoYW5nc2FuIn0.2TTm7UKGaho4CSXZekHv2bPTY70Aydr-bWJThymAOGs");
        System.out.println(verify);
    }
}
