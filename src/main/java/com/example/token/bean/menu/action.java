package com.example.token.bean.menu;

public class action {
    int id;
    private int action_id;
    private String action_name;
    private String action_url;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getAction_id() {
        return action_id;
    }

    public void setAction_id(Integer action_id) {
        this.action_id = action_id;
    }

    public String getAction_name() {
        return action_name;
    }

    public void setAction_name(String action_name) {
        this.action_name = action_name;
    }

    public String getAction_url() {
        return action_url;
    }

    public void setAction_url(String action_url) {
        this.action_url = action_url;
    }

    @Override
    public String toString() {
        return "action{" +
                "id=" + id +
                ", action_id=" + action_id +
                ", action_name='" + action_name + '\'' +
                ", action_url='" + action_url + '\'' +
                '}';
    }
}
