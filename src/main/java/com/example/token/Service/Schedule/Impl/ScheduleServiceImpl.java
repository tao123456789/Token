package com.example.token.Service.Schedule.Impl;

import com.example.token.Entity.BO.schedule.ScheduleBO;
import com.example.token.Entity.BO.schedule.ScheduleTaskBO;
import com.example.token.Mapper.ScheduleMapper;
import com.example.token.Service.EmailService.EmailServiceImpl;
import com.example.token.Service.Schedule.ScheduleService;
import com.example.token.Utils.date.DateUtil;
import com.example.token.Utils.user.UserUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service
public class ScheduleServiceImpl implements ScheduleService {

    @Resource
    private ScheduleMapper scheduleMapper;
    @Resource
    EmailServiceImpl emailServiceImpl;
    @Resource
    UserUtil userUtil;

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
    public Boolean updateScheduleTaskStatus(int taskid,String usermail) throws Exception {
        ScheduleTaskBO scheduleTaskBO=scheduleMapper.getScheduleTaskListById(taskid);
        String content="恭喜您！：【"+scheduleTaskBO.getExcuteTime()+"】的任务：【"+scheduleTaskBO.getTaskContent()+"】 在【"+ new DateUtil().getNowFormat3() +"】已经完成了！请再接再厉，加油！";
        emailServiceImpl.SendToByQQMail("1","【每日任务更新】",content,usermail);
        return scheduleMapper.updateScheduleTaskStatus(taskid);
    }

    @Override
    public Boolean deleteSchedule (int id) {
        return scheduleMapper.deleteSchedule(id);
    }

    @Override
    public Boolean deleteScheduleTask (int id) {
        return scheduleMapper.deleteScheduleTask(id);
    }
}
