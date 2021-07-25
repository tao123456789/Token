package com.example.token.controller.menu;

import com.example.token.Impl.MenuServiceImpl;
import com.example.token.Interface.UserLoginToken;
import com.example.token.bean.menu.action;
import com.example.token.bean.menu.menu;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/menu")
@Api(tags = "菜单权限")
public class MenuController {
    @Autowired
    private MenuServiceImpl menuService;

    @UserLoginToken
    @GetMapping("/getMenu/{userid}")
    @ResponseBody
    @ApiOperation("获取用户权限")
    public menu GetUserMenu(@PathVariable int userid) {

        Integer groupid = menuService.GetUserGroup(userid);
        List<Integer> actionid;//获取用户的菜单权限id
        ArrayList<action> actionArr = new ArrayList<>();//获取各id的名称和url
        menu menu=new menu();

        if (groupid == 0) {
            throw new RuntimeException("用户未加入权限组！");
        } else {
            actionid = menuService.GetGroupAction(groupid);
        }

        System.out.println("用户id:" + userid + ",管理组id：" + groupid + ",权限id:" + actionid);
        for (int i=0;i<actionid.size();i++){
            action action1=menuService.GetActionUrl(actionid.get(i));
//            System.out.println(menuService.GetActionUrl(actionid.get(i)));
//            System.out.println(action1);
            actionArr.add(action1);
        }
//        System.out.println(actionArr);

        menu.setUserID(userid);
        menu.setGroupID(groupid);
        menu.setActionArr(actionArr);

        return menu;
    }
}
