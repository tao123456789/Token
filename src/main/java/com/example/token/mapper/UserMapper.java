package com.example.token.mapper;

import com.example.token.bean.UserDo;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    List<UserDo> GetAllUser();
    UserDo GetUserByName(String username);
    int insertUser(UserDo user);
    int deleteUser(String name);
    int updateUser(UserDo user);

//    token服务
    Integer checkToken(String token);

    void insertToken(String token);
}
