package com.example.token.service;

import com.example.token.bean.UserDo;

import java.util.List;

public interface UserService {
    List<UserDo> GetAllUser();
    UserDo GetUserByName(String name);
    int insertUser(UserDo user);
    int deleteUser(String username);
    int updateUser(UserDo user);
}
