package com.example.token.Mapper;

import com.example.token.BO.user.UserDo;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface UserMapper {
    List<UserDo> GetAllUser();
    UserDo GetUserByUserName(String username);
    UserDo GetUserByUserId(String userid);
    int insertUser(UserDo user);
    int deleteUser(String name);
    int updateUser(UserDo user);

//    token服务
    Integer checkToken(String token);

    void insertToken(String token);
}
