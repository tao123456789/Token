package com.example.token.Impl;

import com.example.token.bean.UserDo;
import com.example.token.service.UserService;
import com.example.token.usermapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;//这里会报错，但并不影响

    @Override
    public List<UserDo> GetAllUser(){
        return userMapper.GetAllUser();
    }

    @Override
    public UserDo GetUserByName(int id){
        return userMapper.GetUserByName(id);
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
