package com.example.token.Utils.user;

import com.example.token.Utils.redis.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class UserUtil {
    @Autowired
    RedisUtils redisUtils;
    @Autowired
    HttpServletRequest httpServletRequest;

    public int getCurrentUserID(){
        String token = httpServletRequest.getHeader("token");
        if(token==null){
            throw new RuntimeException("无token，请重新登录");
        }
        System.out.println("获取当前登录用户token："+token);
        System.out.println("获取当前登录用户id："+(int) redisUtils.get(token));
        return (int) redisUtils.get(token);
    }
}
