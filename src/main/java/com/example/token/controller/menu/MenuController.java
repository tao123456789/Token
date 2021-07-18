package com.example.token.controller.menu;

import com.example.token.Impl.MenuServiceImpl;
import com.example.token.Interface.UserLoginToken;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/menu")
@Api(tags = "菜单权限")
public class MenuController {
    @Autowired
    private MenuServiceImpl menuService;

    @UserLoginToken
    @PostMapping("/getMenu/{userid}")
    @ResponseBody
    @ApiOperation("获取用户权限")
    public String GetUserMenu(@PathVariable int userid) {
        Integer groupid = menuService.GetUserGroup(userid);
        List<Integer> actionid=null;
        if (groupid == 0) {
            throw new RuntimeException("用户未加入权限组！");
        } else {
            actionid = menuService.GetGroupAction(groupid);
        }
        return "用户id:" + userid + ",管理组id：" + groupid + ",权限id:" + actionid;
    }
}
