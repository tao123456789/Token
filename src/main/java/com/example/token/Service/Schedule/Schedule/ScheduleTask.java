package com.example.token.Service.Schedule.Schedule;

import com.example.token.Entity.BO.schedule.ScheduleBO;
import com.example.token.Entity.BO.schedule.ScheduleTaskBO;
import com.example.token.Mapper.ScheduleMapper;
import com.example.token.Utils.date.DateUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
    public class ScheduleTask {
    @Resource
    ScheduleMapper scheduleMapper;

    public void scheduleTask() {
        List<ScheduleBO> scheduleBOList = scheduleMapper.getAllScheduleList();
        for (ScheduleBO scheduleBO : scheduleBOList) {
            //类型转换
            ScheduleTaskBO scheduleTaskBO = new ScheduleTaskBO();
            scheduleTaskBO.setStatus("0");
            scheduleTaskBO.setCreateName(scheduleBO.getCreateName());
            scheduleTaskBO.setCreateTime(new DateUtil().getNowFormat2());
            scheduleTaskBO.setTaskContent(scheduleBO.getTaskContent());
            scheduleTaskBO.setUserid(scheduleBO.getUserid());
            scheduleTaskBO.setExcuteTime(new DateUtil().getNowFormat2());
            scheduleTaskBO.setUpdateName(scheduleBO.getUpdateName());
            scheduleTaskBO.setUpdateTime(new DateUtil().getNowFormat2());
            System.out.println(scheduleTaskBO.toString());
            if (scheduleMapper.addScheduleTask(scheduleTaskBO)) {
                System.out.println("添加成功！");
            }
        }
    }
}
