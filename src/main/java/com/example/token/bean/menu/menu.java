package com.example.token.bean.menu;

import java.util.ArrayList;

public class menu {
    private Integer userID;
    private Integer groupID;
    private String groupName;
    private ArrayList<action> actionArr;

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public Integer getGroupID() {
        return groupID;
    }

    public void setGroupID(Integer groupID) {
        this.groupID = groupID;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public ArrayList<action> getActionArr() {
        return actionArr;
    }

    public void setActionArr(ArrayList<action> actionArr) {
        this.actionArr = actionArr;
    }

    @Override
    public String toString() {
        return "menu{" +
                "userID=" + userID +
                ", groupID=" + groupID +
                ", groupName='" + groupName + '\'' +
                ", actionArr=" + actionArr +
                '}';
    }
}
