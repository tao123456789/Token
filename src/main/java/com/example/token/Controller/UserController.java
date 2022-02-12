package com.example.token.Controller;

import com.example.token.BO.user.UserDo;
import com.example.token.Interface.UserLoginToken;
import com.example.token.Service.MMSService.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@UserLoginToken
@RestController
@CrossOrigin
@Api(tags = "获取用户信息")
@RequestMapping("/user")
public class UserController {
    @Autowired
    @Qualifier("userService1")
    private UserService userService;

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

    @GetMapping("/getUserByUserId/{userid}")
    public UserDo GetUserByUserId(@PathVariable String userid){
//        System.out.println("将要获取的username:"+id);
//        System.out.println("获取到的username:"+userService.GetUserByName(id));
        return userService.GetUserByUserId(userid);
    }

    @GetMapping("/getUserByUserName/{username}")
    public UserDo GetUserByUesrName(@PathVariable String username){
//        System.out.println("将要获取的username:"+id);
//        System.out.println("获取到的username:"+userService.GetUserByName(id));
        return userService.GetUserByUserName(username);
    }

    @PostMapping("/updateUserInfo")
    public Boolean updateUserInfo(@RequestBody UserDo userDo){
        int i=userService.updateUser(userDo);
        System.out.println("更新？："+i);
        return (i==1);
    }

}
