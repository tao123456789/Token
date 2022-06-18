package com.example.token.Api.User;

import com.example.token.Annotation.AspectLogAnnptation;
import com.example.token.Config.Interface.UserLoginToken;
import com.example.token.Entity.BO.module.ModuleBO;
import com.example.token.Entity.BO.user.UserBO;
import com.example.token.Entity.VO.user.UserModuleVO;
import com.example.token.Service.UserService.UserService;
import com.example.token.Utils.user.UserUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@UserLoginToken
@RestController
@CrossOrigin
@Api(tags = "获取用户信息")
@RequestMapping("/user")
public class UserController {
    @Autowired
    @Qualifier("userService1")
    private UserService userService;
    @Resource
    UserUtil userUtil;


    @GetMapping("/getAllUser")
    @AspectLogAnnptation
    public List<UserBO> GetAllUser(){
        UserBO userBO=new UserBO();
        List<UserBO> userBOList = userService.GetAllUser(userBO);
        if (userBOList.isEmpty()) {
            System.out.println("查无此人！！！");
        }
        return userBOList;
    }

    @GetMapping("/getUserByUserId")
    @AspectLogAnnptation
    public UserBO GetUserByUserId(){
        return userService.GetUserByUserId(userUtil.getCurrentUserInfo().getId());
    }

    @GetMapping("/getUserByUserName/{username}")
    @AspectLogAnnptation
    public UserBO GetUserByUesrName(@PathVariable String username){
//        System.out.println("将要获取的username:"+id);
//        System.out.println("获取到的username:"+userService.GetUserByName(id));
        return userService.GetUserByUserName(username);
    }

    @PostMapping("/updateUserInfo")
    @AspectLogAnnptation
    public Boolean updateUserInfo(@RequestBody UserBO userBO){
        if(userBO.getUserPasswd()==""){
            userBO.setUserPasswd(null);
        }
        userBO.setId(userUtil.getCurrentUserInfo().getId());
        int i=userService.updateUserInfo(userBO);
        System.out.println("更新？："+i);
        return (i==1);
    }

    @GetMapping("/GetModule")
    @AspectLogAnnptation
    public List<UserModuleVO> GetModule(){
        int userid=userUtil.getCurrentUserInfo().getId();
        //获取用户模块权限
        List<UserModuleVO> userModuleVOList=userService.getUserModuleByUserId(userid);
        System.out.println("用户获取模块权限："+userModuleVOList.toString());
        return userModuleVOList;
    }

    @GetMapping("/GetAllModuleList")
    @AspectLogAnnptation
    @ApiOperation("获取模块列表")
    public List<ModuleBO> GetAllModuleList(){
        List<ModuleBO> AllModuleList=userService.getAllModuleList();
        System.out.println("模块列表："+AllModuleList.toString());
        return AllModuleList;
    }

    @GetMapping("/GetModuleByUserId")
    @AspectLogAnnptation
    public List<UserModuleVO> GetModuleByUserId(int userid){
        //获取用户模块权限
        List<UserModuleVO> userModuleVOList=userService.getUserModuleByUserId(userid);
        System.out.println("用户获取模块权限："+userModuleVOList.toString());
        return userModuleVOList;
    }

    @GetMapping("/removeModule")
    @AspectLogAnnptation
    @ApiOperation("移除首页模块权限")
    public Boolean removeModule(int id){
        return userService.removeModuleByID(id);
    }

    @GetMapping("/insertUserModule")
    @AspectLogAnnptation
    @ApiOperation("添加模块权限")
    public Boolean insetUserModule(int userid,int moduleid){
        return userService.insertUserModule(userid,moduleid);
    }
}
