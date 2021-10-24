package com.example.token.service;

import com.example.token.BO.user.UserDo;

import java.util.List;

public interface UserService {
    List<UserDo> GetAllUser();
    UserDo GetUserByUserId(String userid);
    UserDo GetUserByUserName(String username);
    int insertUser(UserDo user);
    int deleteUser(String username);
    int updateUser(UserDo user);
}
