package com.example.token.Service.UserService;

import com.example.token.Entity.BO.user.UserBO;
import com.example.token.Entity.VO.user.UserModuleVO;

import java.util.List;

public interface UserService {
    List<UserBO> GetAllUser(UserBO userBO);
    UserBO GetUserByUserId(int userid);
    UserBO GetUserByUserName(String username);
    int insertUser(UserBO user);
    int deleteUser(int userid);
    int updateUser(UserBO user);
    List<UserModuleVO> getUserModuleByUserId(int userid);
}
