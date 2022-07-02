package com.example.token.Service.EmailService;

import com.alibaba.fastjson.JSONObject;
import com.example.token.Entity.BO.subscriber.SubscriberBO;
import com.example.token.Mapper.SubscriberMapper;
import com.example.token.Utils.rabbitMQ.MQUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EmailServiceImpl {
    @Resource
    SubscriberMapper subscriberMapper;

    @Resource
    MQUtil mqUtil;

    //推送订阅者邮件
    public void SendMessageToSubscriberBYMQ(String type,String tittle,String content) throws Exception {
        List<SubscriberBO> subscriberBOList=subscriberMapper.getSubscriberByType(type);
        for(SubscriberBO subscriberBO:subscriberBOList) {
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("ToEmail",subscriberBO.getRemark());
            jsonObject.put("Tittle",tittle);
            jsonObject.put("Content",content);
            System.out.println("发送： "+subscriberBO.getName()+"  邮件，账号为： "+subscriberBO.getRemark()+" ，内容为： "+content);
            mqUtil.send("EmailMessage",jsonObject.toJSONString());
            //邮件直接发送
            //qqEmailUtils.SendToByQQ(tittle, content, subscriberBO.getMessage());
        }
    }

    //推送单个邮箱
    public void SendWBMessageToOneBYMQ(String tittle,String content,String ToEMail) throws Exception {
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("ToEmail",ToEMail);
        jsonObject.put("Content",content);
        jsonObject.put("Tittle",tittle);
        System.out.println("发送： "+ToEMail+"  邮件，账号为： "+ ToEMail +" ，内容为： "+content);
        mqUtil.send("EmailMessage",jsonObject.toJSONString());
        //邮件直接发送
        //qqEmailUtils.SendToByQQ(tittle, content, subscriberBO.getMessage());
    }
}
