package com.example.token.Impl.MMSService;

import com.example.token.BO.user.UserDo;
import com.example.token.Mapper.UserMapper;
import com.example.token.Service.MMSService.UserService;
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
        int i=0;
        try {
            i = userMapper.updateUser(user);
            if(i==1){
                System.out.println("更新成功");
                return i;
            }
        }catch (Exception e){
            System.out.println("更新失败");
        }
        return i;
    }

    @Override
    public int insertUser(UserDo user){
        return userMapper.insertUser(user);
    }

}
