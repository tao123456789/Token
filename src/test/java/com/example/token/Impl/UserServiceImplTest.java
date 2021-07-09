package com.example.token.Impl;

import com.example.token.bean.UserDo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceImplTest {
    @Autowired
    private UserServiceImpl userService;

    @Test
    void getAllUser() {
        List<UserDo> userDoList=userService.GetAllUser();
        System.out.println(userDoList);
        System.out.println(userService.GetUserByName(123));
    }

    @Test
    void getUserByName() {
    }
}