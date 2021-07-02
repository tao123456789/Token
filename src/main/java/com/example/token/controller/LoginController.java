package com.example.token.controller;

import com.example.token.Impl.TokenServiceImpl;
import com.example.token.Interface.UserLoginToken;
import com.example.token.bean.UserDo;
import com.example.token.service.UserService;
import io.swagger.annotations.Api;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/user")
@Api(tags = "用户登录")
public class LoginController{
    @Reference
    UserService userService;
    @Reference
    TokenServiceImpl tokenService;

    //登录
    @PostMapping ("/getToken")
    @ResponseBody
    public String login(@RequestBody UserDo userDo) {
        Boolean isLogin=true;
        String token="";
        TokenServiceImpl getToken = new TokenServiceImpl();

        if(isLogin){
            token = getToken.getToken();
        }
        return token;
    }

    @UserLoginToken
    @GetMapping("/getMessage")
    public String getMessage() {
        return "你已通过验证";
    }
}
