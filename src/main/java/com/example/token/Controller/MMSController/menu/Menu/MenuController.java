package com.example.token.Controller.MMSController.menu.Menu;

import com.alibaba.fastjson.JSONObject;
import com.example.token.BO.menu.action;
import com.example.token.Interface.UserLoginToken;
import com.example.token.Service.MMSService.MenuService.MenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/menu")
@Api(tags = "菜单权限")
public class MenuController {
    @Autowired
    @Qualifier("MenuService1")
    private MenuService menuService;

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
        ArrayList<JSONObject> jsonObjectsVO = new ArrayList<>();
        for (action item : actionArr) {
            JSONObject jsonObject = new JSONObject();
            if (item.getAction_level().equals("1")) {
                jsonObject.put("icon", item.getAction_icon());
                jsonObject.put("name", item.getAction_name());
                jsonObject.put("url", item.getAction_url());

                //Children目录
                ArrayList<JSONObject> jsonObjects = new ArrayList<>();
                for (action item2 : actionArr) {
                    if (!Objects.equals(item2.getAction_parent_id(), "")) {
                        if (Objects.equals(item2.getAction_parent_id(), item.getAction_id())) {
                            JSONObject jsonObject1 = new JSONObject();
//                            jsonObject1.put("icon", item2.getAction_icon());
                            jsonObject1.put("name", item2.getAction_name());
                            jsonObject1.put("url", item2.getAction_url());
                            jsonObjects.add(jsonObject1);
                        }
                    }
                    jsonObject.put("children", jsonObjects);
                }
            }
            if(!jsonObject.isEmpty()) {
                jsonObjectsVO.add(jsonObject);
            }
        }
        System.out.println("全部的菜单权限为：" + jsonObjectsVO.toString());
        return jsonObjectsVO.toString();
    }
}