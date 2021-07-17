package com.example.token.controller.menu;

import com.example.token.Impl.MenuServiceImpl;
import io.swagger.annotations.Api;
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

    @PostMapping("/getMenu/{userid}")
    @ResponseBody
    public String GetUserMenu(@PathVariable int    userid){
        int groupid=menuService.GetUserGroup(userid);
        List<Integer> actionid=menuService.GetGroupAction(groupid);
        return "用户id:"+userid+",管理组id："+groupid+",权限id:"+actionid;
    }
}
