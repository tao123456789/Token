package com.example.token.service;

import com.example.token.BO.menu.action;

import java.util.List;

public interface MenuService {
    Integer GetUserGroup(int userid);
    List<Integer> GetGroupAction(int group);
    action GetActionUrl(Integer actionid);
}
