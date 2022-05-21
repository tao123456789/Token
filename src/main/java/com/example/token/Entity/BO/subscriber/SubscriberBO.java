package com.example.token.Entity.BO.subscriber;

import lombok.Data;

@Data
public class SubscriberBO {
    private int id;
    /*
    type类型：
    1,QQ邮件推送的订阅
     */
    private String type;
    private String subscriber;
    private String message;
    private String status;

    @Override
    public String toString() {
        return "SubscriberBO{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", subscriber='" + subscriber + '\'' +
                ", message='" + message + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
