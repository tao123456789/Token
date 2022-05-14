package com.example.token.Service.UserService;

import com.example.token.Entity.BO.user.UserBO;
import com.example.token.Entity.VO.user.UserModuleVO;

import java.util.List;

public interface UserService {
    List<UserBO> GetAllUser();
    UserBO GetUserByUserId(String userid);
    UserBO GetUserByUserName(String username);
    int insertUser(UserBO user);
    int deleteUser(String username);
    int updateUser(UserBO user);
    List<UserModuleVO> getUserModuleByUserId(int userid);
}
