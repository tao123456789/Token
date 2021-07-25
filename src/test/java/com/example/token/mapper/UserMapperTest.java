package com.example.token.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class UserMapperTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    void getAllUser() {
        System.out.println(userMapper.GetAllUser());
    }
}