package com.example.token.bean;


public class UserDo {
    private String id;

    private String userName;

    private String userPasswd;

    private String reaName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserPasswd() {
        return userPasswd;
    }

    public void setUserPasswd(String userPasswd) {
        this.userPasswd = userPasswd == null ? null : userPasswd.trim();
    }

    public String getReaName() {
        return reaName;
    }

    public void setReaName(String reaName) {
        this.reaName = reaName;
    }

    @Override
    public String toString() {
        return "UserDo{" +
                "id='" + id + '\'' +
                ", userName='" + userName + '\'' +
                ", userPasswd='" + userPasswd + '\'' +
                ", reaName='" + reaName + '\'' +
                '}';
    }
}
