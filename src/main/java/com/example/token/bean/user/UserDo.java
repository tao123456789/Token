package com.example.token.bean.user;

import lombok.Data;

@Data
public class UserDo {
    private int id;

    private String userName;

    private String userPasswd;

    private String realName;

    private String ip;

    private String area;

    private String brower;

    private String os;

    @Override
    public String toString() {
        return "UserDo{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", userPasswd='" + userPasswd + '\'' +
                ", realName='" + realName + '\'' +
                ", ip='" + ip + '\'' +
                ", area='" + area + '\'' +
                ", brower='" + brower + '\'' +
                ", os='" + os + '\'' +
                '}';
    }
}
