package com.example.token.Api;

import com.example.token.Annotation.AspectLogAnnptation;
import com.example.token.Config.Interface.PassToken;
import com.example.token.Entity.BO.user.UserBO;
import com.example.token.Mapper.ModuleMapper;
import com.example.token.Service.EmailService.EmailServiceImpl;
import com.example.token.Service.UserService.UserService;
import com.example.token.Utils.basicEnum.ResultCode;
import com.example.token.Utils.basicresponse.BasicResponse;
import com.example.token.Utils.commonUtil.CommonUtil;
import com.example.token.Utils.http.HttpUtil;
import com.example.token.Utils.redis.RedisUtils;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@PassToken
@RestController
@CrossOrigin
@RequestMapping("/")
@Api(tags = "用户登录")
public class LoginController{

    @Autowired
    @Qualifier("userService1")
    private UserService userService;
    @Resource
    RedisUtils redisUtils;
    @Resource
    EmailServiceImpl emailServiceImpl;
    @Resource
    HttpUtil httpUtil;
    @Resource
    HttpServletRequest httpServletRequest;
    @Resource
    ModuleMapper moduleMapper;

    //登录
    @PostMapping ("/login")
    @ResponseBody
    @AspectLogAnnptation
    public String login(@RequestBody UserBO userBO) {
        UserBO userBean = new UserBO();
        userBean = userService.GetUserByUserName(userBO.getUserName());
        //验证登录，获取token
        if(userBean.getUserPasswd().equals(userBO.getUserPasswd())){
            userBO.setId(userBean.getId());
            userBO.setRealName(userBean.getRealName());
            userBO.setIp(httpUtil.getIpAddr(httpServletRequest));
            userBO.setBrower(CommonUtil.getLoginInfo().getBrower());
            userBO.setOs(CommonUtil.getLoginInfo().getOs());
            //生成token
            String token = UUID.randomUUID().toString().replaceAll("-", "");
            try{
                //保存token,key为token,value为id,有效期为1个小时
                redisUtils.set(token, userBO.getId(), 1, TimeUnit.HOURS);
                //更新登录信息
                if(userService.updateUser(userBO)==1){
                    System.out.println("用户登录信息更新成功！");
                }else{
                    System.out.println("用户登录信息更新失败！");
                };
                String content="【登录提醒】尊敬的管理员，您好，用户： "+ userBO.getRealName()+"("+ userBO.getUserName()+") 正使用IP地址： 【"+ CommonUtil.getLoginInfo().getIp()
                        + "】 于 【"+ userBO.getLogintime()+"】 位于 【"+ userBO.getArea()+"】 区域使用 【"
                        + CommonUtil.getLoginInfo().getOs()+"】 操作系统的 【"+ CommonUtil.getLoginInfo().getBrower()+"】 浏览器登录您的系统！";
                emailServiceImpl.SendMessageToSubscriberBYMQ("1","【登录提醒】",content);
                return token;
            }catch (Exception e){
                System.out.println(e);
            }
        }else{
            System.out.println("登录密码错误！！！");
        }
        return "false";
    }

    @PostMapping("/register")
    @ResponseBody
    @AspectLogAnnptation
    public BasicResponse register(@RequestBody UserBO userBO) throws Exception {
        System.out.println(userBO.toString());
        UserBO userBO1=new UserBO();
        userBO1.setInviteAuth(userBO.getBeinviteauth());
        if(userService.GetAllUser(userBO1).isEmpty()){
            return new BasicResponse(ResultCode.ERROR,"邀请码不存在！！！");
        }else{
            userBO1.setInviteAuth(null);
            userBO1.setUserName(userBO.getUserName());
            if(!userService.GetAllUser(userBO1).isEmpty()){
                return new BasicResponse(ResultCode.ERROR,"用户名已存在！！！");
            }else {
                String password=UUID.randomUUID().toString().replaceAll("-", "");
                userBO.setIp(httpUtil.getIpAddr(httpServletRequest));
                userBO.setBrower(CommonUtil.getLoginInfo().getBrower());
                userBO.setOs(CommonUtil.getLoginInfo().getOs());
                userBO.setRealName("游客");
                userBO.setUserPasswd(password);
                userBO.setInviteAuth(UUID.randomUUID().toString().replaceAll("-", ""));
                System.out.println(userBO);
                if ((userService.insertUser(userBO) == 1)) {
                    moduleMapper.insertUserModule(userService.GetUserByUserName(userBO.getUserName()).getId(),1);
                    return new BasicResponse(ResultCode.SUCCESS,password);
                }
            }
        }
        return new BasicResponse(ResultCode.ERROR,"注册失败！！！");
    }

    @PassToken
    @GetMapping("/getMessage")
    public String getMessage() throws MessagingException {
        return "你已通过验证";
    }
}
