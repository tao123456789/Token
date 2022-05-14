package com.example.token.Entity.VO.user;

import lombok.Data;

@Data
public class UserModuleVO {
    int id;
    int userid;
    int moduleid;
    String module_name;
    String module_url;
    String img_url;
    String description;

    @Override
    public String toString() {
        return "UserModuleVO{" +
                "id=" + id +
                ", userid=" + userid +
                ", moduleid=" + moduleid +
                ", module_name='" + module_name + '\'' +
                ", module_url='" + module_url + '\'' +
                ", img_url='" + img_url + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
