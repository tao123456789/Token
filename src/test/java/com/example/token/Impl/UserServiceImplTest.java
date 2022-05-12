package com.example.token.Impl;

import com.example.token.Entity.BO.user.UserDo;
import com.example.token.Service.UserService.Impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

class UserServiceImplTest {
    @Autowired
    private UserServiceImpl userService;

    @Test
    void getAllUser() {
        List<UserDo> userDoList=userService.GetAllUser();
        System.out.println(userDoList);
        System.out.println(userService.GetUserByUserId("1"));
    }

    @Test
    void getUserByName() {
    }
}