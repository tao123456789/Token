package com.example.token.usermapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class UserMapperTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    void getAllUser() {
        System.out.println(userMapper.GetAllUser().get(0).getUserName());
    }
}