package com.example.token.usermapper;

import com.example.token.bean.UserDo;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    List<UserDo> GetAllUser();
    UserDo GetUserByName(String name);
    int insertUser(UserDo user);
    int deleteUser(String name);
    int updateUser(UserDo user);
}
