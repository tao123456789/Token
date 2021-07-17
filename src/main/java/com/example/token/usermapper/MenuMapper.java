package com.example.token.usermapper;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface MenuMapper {
    //获取用户权限组
    int GetUserGroup(int userid);
    //获取权限列表
    List<Integer> GetGroupAction(int groupid);
}
