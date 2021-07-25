package com.example.token.Impl;

import com.example.token.service.MenuService;
import com.example.token.mapper.MenuMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    @Resource
    MenuMapper menuMapper;

    @Override
    public Integer GetUserGroup(int userid){
        return menuMapper.GetUserGroup(userid);
    };

    @Override
    public List<Integer> GetGroupAction(int groupid){
        return menuMapper.GetGroupAction(groupid);
    }

}
