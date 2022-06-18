package com.example.token.Entity.VO.user;

import lombok.Data;

@Data
public class UserModuleVO {
    int id;
    int userid;
    String username;
    String realname;
    int moduleid;
    String module_name;
    String module_url;
    String img_url;
    String description;
}
