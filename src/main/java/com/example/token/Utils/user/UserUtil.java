package com.example.token.Utils.user;

import com.example.token.Entity.BO.user.UserBO;
import com.example.token.Service.UserService.Impl.UserServiceImpl;
import com.example.token.Utils.redis.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Component
public class UserUtil {
    @Autowired
    RedisUtils redisUtils;
    @Autowired
    HttpServletRequest httpServletRequest;
    @Resource
    UserServiceImpl userServiceImpl;

    public UserBO getCurrentUserInfo(){
        String token = httpServletRequest.getHeader("token");
        if(token==null){
            throw new RuntimeException("无token，请重新登录");
        }
        int userid=(int) redisUtils.get(token);
        UserBO userBO=userServiceImpl.GetUserByUserId(userid);
        System.out.println("当前token用户："+userBO.getUserName());
        return userBO;
    }
}
