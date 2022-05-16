package com.example.token.Api.Setting;

import com.example.token.Config.Interface.UserLoginToken;
import com.example.token.Entity.BO.setting.SettingBO;
import com.example.token.Service.SettingService.SettingServiceImpl;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@UserLoginToken
@Slf4j
@RestController
@RequestMapping("/setting")
public class SettingApi {
    @Autowired
    SettingServiceImpl settingServiceImpl;

    @UserLoginToken
    @GetMapping("/getSettingList")
    @ApiOperation("获取设置列表")
    public List<SettingBO> getSetting(@RequestBody SettingBO settingBO){
        return settingServiceImpl.getSetting(settingBO);
    }

    @UserLoginToken
    @PostMapping("/updateSettingByName")
    @ApiOperation("获取设置列表")
    public Boolean updateSettingByName(@RequestBody SettingBO settingBO){
        return settingServiceImpl.updateSettingByName(settingBO);
    }
}