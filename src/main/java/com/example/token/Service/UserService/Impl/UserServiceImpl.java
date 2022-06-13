package com.example.token.Service.UserService.Impl;

import com.example.token.Entity.BO.user.UserBO;
import com.example.token.Entity.VO.user.UserModuleVO;
import com.example.token.Mapper.ModuleMapper;
import com.example.token.Mapper.UserMapper;
import com.example.token.Service.UserService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("userService1")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Resource
    ModuleMapper moduleMapper;

    @Override
    public List<UserBO> GetAllUser(UserBO userBO){
        return userMapper.GetAllUser(userBO);
    }

    @Override
    public UserBO GetUserByUserId(int userid){
        return userMapper.GetUserByUserId(userid);
    }

    @Override
    public UserBO GetUserByUserName(String username) {
        return userMapper.GetUserByUserName(username);
    }

    @Override
    public int deleteUser(int nameid){
        return userMapper.deleteUser(nameid);
    }

    @Override
    public int updateUser(UserBO user){
        return userMapper.updateUser(user);
    }

    @Override
    public int updateUserInfo(UserBO user){
        return userMapper.updateUserInfo(user);
    }

    @Override
    public int insertUser(UserBO user){
        return userMapper.insertUser(user);
    }

    @Override
    public List<UserModuleVO> getUserModuleByUserId(int userid) {
        return moduleMapper.getUserModuleByUserId(userid);
    }

}
