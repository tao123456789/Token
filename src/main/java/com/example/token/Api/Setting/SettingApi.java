package com.example.token.Api.Setting;

import com.example.token.Annotation.AspectLogAnnptation;
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
    @PostMapping("/getSettingList")
    @ApiOperation("获取设置列表")
    @AspectLogAnnptation
    public List<SettingBO> getSetting(SettingBO settingBO){
        return settingServiceImpl.getSetting(settingBO);
    }

    @UserLoginToken
    @PostMapping("/updateSettingByName")
    @ApiOperation("修改设置列表")
    @AspectLogAnnptation
    public Boolean updateSettingByName(@RequestBody SettingBO settingBO){
        return settingServiceImpl.updateSettingByName(settingBO);
    }
}
