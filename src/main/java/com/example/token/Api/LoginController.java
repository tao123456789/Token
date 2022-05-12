package com.example.token.Api;

import com.example.token.Config.Interface.PassToken;
import com.example.token.Config.Interface.UserLoginToken;
import com.example.token.Entity.BO.user.UserDo;
import com.example.token.Service.UserService.UserService;
import com.example.token.Utils.redis.RedisUtils;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@PassToken
@RestController
@CrossOrigin
@RequestMapping("/")
@Api(tags = "用户登录")
public class LoginController{

    @Autowired
    @Qualifier("userService1")
    private UserService userService;

    @Resource
    RedisUtils redisUtils;

    //登录
    @PostMapping ("/login")
    @ResponseBody
    public String login(@RequestBody UserDo userDo) {
        System.out.println("登录信息为："+userDo);
        UserDo userBean = new UserDo();
        userBean = userService.GetUserByUserName(userDo.getUserName());
        //验证登录，获取token
        if(userBean.getUserPasswd().equals(userDo.getUserPasswd())){
            userDo.setId(userBean.getId());
            //生成token
            String token = UUID.randomUUID().toString().replaceAll("-", "");
            try{
                //保存token,key为token,value为id,有效期为1个小时
                redisUtils.set(token, userDo.getId(), 1, TimeUnit.MINUTES);
                //更新登录信息
                if(userService.updateUser(userDo)==1){
                    System.out.println("用户登录信息更新成功！");
                }else{
                    System.out.println("用户登录信息更新失败！");
                };
                return token;
            }catch (Exception e){
                System.out.println(e);
            }
        }else{
            System.out.println("登录密码错误！！！");
        }
        return "登录失败";
    }

    @UserLoginToken
    @GetMapping("/getMessage")
    public String getMessage() {
        return "你已通过验证";
    }
}
