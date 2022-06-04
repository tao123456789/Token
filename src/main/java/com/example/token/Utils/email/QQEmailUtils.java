package com.example.token.Utils.email;

import com.example.token.Entity.BO.setting.SettingBO;
import com.example.token.Mapper.SettingMapper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Component
public class QQEmailUtils {

    @Resource
    SettingMapper settingMapper;

    public void SendToByQQ(String tittle,String content,String ToEmail) throws Exception {
        SettingBO settingBO=new SettingBO();
        settingBO.setType(1);
        settingBO.setName("QQAccount");
        String QQAccount=settingMapper.getSetting(settingBO).get(0).getCode();
        settingBO.setName("QQSendAuth");
        String QQSendAuth=settingMapper.getSetting(settingBO).get(0).getCode();
        System.out.println("QQ账号QQAccount："+QQAccount+"，授权码QQSendAuth："+QQSendAuth);
        try {
            Properties properties = new Properties();
            properties.put("mail.transport.protocol", "smtp");// 连接协议
            properties.put("mail.smtp.host", "smtp.qq.com");// 主机名
            properties.put("mail.smtp.port", 465);// 端口号
            properties.put("mail.smtp.auth", "true");
            properties.put("mail.smtp.ssl.enable", "true");//设置是否使用ssl安全连接 ---一般都使用
            properties.put("mail.debug", "true");//设置是否显示debug信息 true 会在控制台显示相关信息
            //得到回话对象
            Session session = Session.getInstance(properties);
            // 获取邮件对象
            Message message = new MimeMessage(session);
            //
            message.setContent(content,"text/html;charset=UTF-8");
            //设置发件人邮箱地址
            message.setFrom(new InternetAddress(QQAccount));
            //设置收件人地址
            message.setRecipients(MimeMessage.RecipientType.TO, new InternetAddress[]{new InternetAddress(ToEmail)});
            //设置邮件标题
            message.setSubject(tittle);
            //设置邮件内容
            message.setText(content);

            //得到邮差对象
            Transport transport = session.getTransport();
            //连接自己的邮箱账户
            transport.connect(QQAccount, QQSendAuth);//密码为刚才得到的授权码
            transport.sendMessage(message, message.getAllRecipients());
        }catch (Exception e){
            System.out.println("发给 "+ToEmail+" 的邮件发送失败： "+e);
            throw new Exception("发送邮件失败！！！");
        }
    }
}
