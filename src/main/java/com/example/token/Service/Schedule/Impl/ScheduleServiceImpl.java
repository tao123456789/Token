package com.example.token.Service.Schedule.Impl;

import com.example.token.BO.schedule.ScheduleBO;
import com.example.token.BO.schedule.ScheduleTaskBO;
import com.example.token.Mapper.ScheduleMapper;
import com.example.token.Service.Schedule.ScheduleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service
public class ScheduleServiceImpl implements ScheduleService {

    @Resource
    private ScheduleMapper scheduleMapper;

    @Override
    public List<ScheduleTaskBO> getScheduleTaskList(int userid, String startTime) {
        System.out.println("获取task任务列表");
        return scheduleMapper.getScheduleTaskList(userid,startTime);
    }

    @Override
    public List<ScheduleBO> getScheduleList(int userid) {
        return scheduleMapper.getScheduleList(userid);
    }

    @Override
    public Boolean addSchedule(ScheduleBO scheduleBO) {
        return scheduleMapper.addSchedule(scheduleBO);
    }

    @Override
    public Boolean addScheduleTask(ScheduleTaskBO scheduleTaskBO) {
        return scheduleMapper.addScheduleTask(scheduleTaskBO);
    }

    @Override
    public Boolean updateScheduleTaskStatus(int taskid) {
        return scheduleMapper.updateScheduleTaskStatus(taskid);
    }
}
