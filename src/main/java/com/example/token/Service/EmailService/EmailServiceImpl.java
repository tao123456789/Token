package com.example.token.Service.EmailService;

import com.example.token.Entity.BO.subscriber.SubscriberBO;
import com.example.token.Mapper.SubscriberMapper;
import com.example.token.Utils.email.QQEmailUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import java.util.List;

@Service
public class EmailServiceImpl {
    @Resource
    SubscriberMapper subscriberMapper;
    @Resource
    QQEmailUtils qqEmailUtils;
    public void SendToByQQ(String type,String tittle,String content) throws MessagingException {
        List<SubscriberBO> subscriberBOList=subscriberMapper.getSubscriberByType(type);
        for(SubscriberBO subscriberBO:subscriberBOList) {
            System.out.println("发送： "+subscriberBO.getSubscriber()+"  邮件，账号为： "+subscriberBO.getMessage()+" ，内容为： "+content);
            qqEmailUtils.SendToByQQ(tittle, content, subscriberBO.getMessage());
        }
    }
}
