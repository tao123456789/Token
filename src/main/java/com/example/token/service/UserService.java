package com.example.token.service;

import com.example.token.bean.UserDo;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    public UserDo findUserById(String userId) {
        UserDo userForBase = null;
        userForBase.setId("123");
        userForBase.setUserName("yt");
        userForBase.setUserPasswd("123");
        return userForBase;
    }
    public UserDo findUserByUsername(String username){
        UserDo userForBase = null;
        userForBase.setId("123");
        userForBase.setUserName("yt");
        userForBase.setUserPasswd("123");
        return userForBase;
    }
}
