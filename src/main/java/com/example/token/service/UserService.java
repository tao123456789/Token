package com.example.token.service;

import com.example.token.bean.UserDo;

import java.util.List;

public interface UserService {
    List<UserDo> GetAllUser();
    UserDo GetUserByName(int id);
    int insertUser(UserDo user);
    int deleteUser(String username);
    int updateUser(UserDo user);
}
