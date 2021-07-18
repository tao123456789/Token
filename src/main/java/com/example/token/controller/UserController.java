package com.example.token.controller;

import com.example.token.Impl.UserServiceImpl;
import com.example.token.Interface.UserLoginToken;
import com.example.token.bean.UserDo;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@UserLoginToken
@RestController
@Api(tags = "获取用户信息")
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/getAllUser")
    public List<UserDo> GetAllUser(){

        List<UserDo> userDoList = null;
        if (!userService.GetAllUser().isEmpty()) {
            userDoList = userService.GetAllUser();
//            System.out.println("获取到的userlist:"+userDoList);
        }else {
            System.out.println("查无此人！！！");
        }
        return userDoList;
    }

    @GetMapping("/getUser/{username}")
    public UserDo GetUser(@PathVariable String username){
//        System.out.println("将要获取的username:"+id);
//        System.out.println("获取到的username:"+userService.GetUserByName(id));
        return userService.GetUserByName(username);
    }

}
