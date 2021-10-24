package com.example.token.Impl;

import com.example.token.bean.user.UserDo;
import com.example.token.mapper.UserMapper;
import com.example.token.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
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
        return userMapper.updateUser(user);
    }

    @Override
    public int insertUser(UserDo user){
        return userMapper.insertUser(user);
    }

}
