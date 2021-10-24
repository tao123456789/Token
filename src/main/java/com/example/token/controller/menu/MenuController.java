package com.example.token.controller.menu;

import com.alibaba.fastjson.JSONObject;
import com.example.token.BO.menu.action;
import com.example.token.Impl.MenuServiceImpl;
import com.example.token.Interface.UserLoginToken;
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
    public String GetUserMenu(@PathVariable int userid) {

        Integer groupid = menuService.GetUserGroup(userid);
        List<Integer> actionid;//获取用户的菜单权限id
        //用户权限集合
        ArrayList<action> actionArr = new ArrayList<>();

        if (groupid == 0) {
            throw new RuntimeException("用户未加入权限组！");
        } else {
            actionid = menuService.GetGroupAction(groupid);
        }

        System.out.println("用户id:" + userid + ",管理组id：" + groupid + ",权限id:" + actionid);
        for (int i = 0; i < actionid.size(); i++) {
            action action1 = menuService.GetActionUrl(actionid.get(i));
            actionArr.add(action1);
        }

        //组装数据
        JSONObject jsonObject = new JSONObject();
        for (action item : actionArr) {
            if (item.getAction_level().equals("1")) {
                jsonObject.put("icon", item.getAction_icon());
                jsonObject.put("name", item.getAction_name());
                jsonObject.put("url", item.getAction_url());
                //Children目录
                ArrayList<JSONObject> jsonObjects = new ArrayList<>();

                for (action item2 : actionArr) {
                    if (item2.getAction_parent_id().equals("")) {
                        System.out.println(item2.getAction_name() + "的父节点为空");
                    } else {
                        if (item2.getAction_parent_id().equals(item.getAction_id())) {
                            System.out.println(item2.getAction_name() + "的父节点不为空");
                            JSONObject jsonObject1 = new JSONObject();
                            jsonObject1.put("icon", item2.getAction_icon());
                            jsonObject1.put("name", item2.getAction_name());
                            jsonObject1.put("url", item2.getAction_url());
                            jsonObjects.add(jsonObject1);
                            System.out.println("添加节点"+jsonObject1.toString());
                            System.out.println("获取的菜单权限为：" + jsonObjects.toString());
                        }
                    }
                }
                jsonObject.put("children", jsonObjects);
            }
        }
        System.out.println("全部的菜单权限为：" + jsonObject.toString());
        return jsonObject.toString();
    }
}
