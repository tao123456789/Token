package com.example.token.Mapper;

import com.example.token.Entity.BO.user.UserBO;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface UserMapper {
    List<UserBO> GetAllUser(UserBO userBO);
    UserBO GetUserByUserName(String username);
    UserBO GetUserByUserId(int userid);
    int insertUser(UserBO user);
    int deleteUser(int userid);
    int updateUser(UserBO user);

//    token服务
    Integer checkToken(String token);

    void insertToken(String token);
}
