package com.example.token.Entity.BO.subscriber;

import lombok.Data;

@Data
public class SubscriberBO {
    private int id;
    private String type;
    private String subscriber;
    private String message;

    @Override
    public String toString() {
        return "SubscriberBO{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", subscriber='" + subscriber + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
