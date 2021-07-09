package com.example.token.controller;

import com.example.token.Impl.TokenServiceImpl;
import com.example.token.Impl.UserServiceImpl;
import com.example.token.Interface.UserLoginToken;
import com.example.token.bean.UserDo;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/")
@Api(tags = "用户登录")
public class LoginController{

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    TokenServiceImpl getToken;

    //登录
    @PostMapping ("/getToken")
    @ResponseBody
    public String login(@RequestBody UserDo userDo) {

        Boolean isLogin = false;
        String token="";
        UserDo userBean=userService.GetUserByName(userDo.getUserName());
//
//        System.out.println(userService.GetUserByName(userDo.getId()).getUserPasswd());
//        System.out.println(userDo);

        if(userBean.getUserPasswd().equals(userDo.getUserPasswd())){
            token = getToken.getToken(userBean.getId(),userDo.getUserName());
            isLogin=true;
        }else{
            System.out.println("密码错误！！！");
        }
        return token;
    }

    @GetMapping("/getAllUser")
    public List<UserDo> getAllUser(){
//        System.out.println("获取所有的user信息："+userService.GetAllUser());
//        System.out.println("获取某一ID的密码:"+userService.GetUserByName(1));
        return userService.GetAllUser();
    }

    @UserLoginToken
    @GetMapping("/getMessage")
    public String getMessage() {
        return "你已通过验证";
    }
}
