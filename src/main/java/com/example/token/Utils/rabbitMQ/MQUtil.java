package com.example.token.Utils.rabbitMQ;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MQUtil {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(String Queues,String Context) {
        System.out.println("向"+Queues+"队列发送数据："+Context);
        this.rabbitTemplate.convertAndSend(Queues, Context);
    }
}
