package com.example.token.Controller;

import com.example.token.BO.user.UserDo;
import com.example.token.Impl.TokenServiceImpl;
import com.example.token.Interface.PassToken;
import com.example.token.Interface.UserLoginToken;
import com.example.token.Service.MMSService.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@PassToken
@RestController
@CrossOrigin
@RequestMapping("/")
@Api(tags = "用户登录")
public class LoginController{

    @Autowired
    @Qualifier("userService1")
    private UserService userService;

    @Autowired
    TokenServiceImpl Token;

    //登录
    @PostMapping ("/getToken")
    @ResponseBody
    public String login(@RequestBody UserDo userDo) {

        Boolean isLogin = false;
        String token="";
        UserDo userBean=userService.GetUserByUserName(userDo.getUserName());

        //验证登录，获取token
        if(userBean.getUserPasswd().equals(userDo.getUserPasswd())){
            //验证通过，获取token
            token = Token.getToken(userBean.getId(),userDo.getUserName());
            try{
                int tokenResult = Token.checkToken(token);
                if(tokenResult==1){
                }else {
                    Token.insertToken(token);
                }
            }catch (Exception e){
                System.out.println(e);
            }

            isLogin=true;

            //返回用户权限内容

        }else{
            System.out.println("密码错误！！！");
        }
        return token;
    }

    @UserLoginToken
    @GetMapping("/getMessage")
    public String getMessage() {
        return "你已通过验证";
    }
}
