package com.example.token.service;

import java.util.List;

public interface MenuService {
    Integer GetUserGroup(int userid);
    List<Integer> GetGroupAction(int group);
}
