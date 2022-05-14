package com.example.token.Service.SettingService;

import com.example.token.Entity.BO.setting.SettingBO;
import com.example.token.Mapper.SettingMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SettingServiceImpl {
    @Resource
    SettingMapper settingMapper;

    public List<SettingBO> getSetting(SettingBO settingBO){
        System.out.println(settingBO);
        return settingMapper.getSetting(settingBO);
    }
    public Boolean updateSettingByName(SettingBO settingBO){
        return settingMapper.updateSettingByName(settingBO);
    }
}
