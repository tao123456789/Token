package com.example.token.Service.UserService.Impl;

import com.example.token.Entity.BO.user.UserDo;
import com.example.token.Mapper.UserMapper;
import com.example.token.Service.UserService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService1")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<UserDo> GetAllUser(){
        return userMapper.GetAllUser();
    }

    @Override
    public UserDo GetUserByUserId(String userid){
        return userMapper.GetUserByUserId(userid);
    }

    @Override
    public UserDo GetUserByUserName(String username) {
        return userMapper.GetUserByUserName(username);
    }

    @Override
    public int deleteUser(String name){
        return userMapper.deleteUser(name);
    }

    @Override
    public int updateUser(UserDo user){
        System.out.println("更新用户登陆信息："+user);
        return userMapper.updateUser(user);
    }

    @Override
    public int insertUser(UserDo user){
        return userMapper.insertUser(user);
    }

}
