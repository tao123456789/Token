package com.example.token.service;

import java.util.List;

public interface MenuService {
    int GetUserGroup(int userid);
    List<Integer> GetGroupAction(int group);
}
