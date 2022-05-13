package com.example.token.Api.Schedule;

import com.example.token.Config.Interface.UserLoginToken;
import com.example.token.Entity.BO.schedule.ScheduleBO;
import com.example.token.Entity.BO.schedule.ScheduleTaskBO;
import com.example.token.Service.Schedule.Impl.ScheduleServiceImpl;
import com.example.token.Service.Schedule.Schedule.ScheduleTask;
import com.example.token.Utils.date.DateUtil;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import java.util.List;

@UserLoginToken
@Slf4j
@RestController
@RequestMapping("/DailySchedule")
public class ScheduleController {

    @Resource
    private ScheduleServiceImpl scheduleServiceImpl;

    @Resource
    ScheduleTask scheduleTask;

    @UserLoginToken
    @GetMapping("/getScheduleTaskList/{userid}")
    @ApiOperation("获取每日任务列表")
    public List<ScheduleTaskBO> getScheduleTaskList(@PathVariable("userid")  int userid) {
        return scheduleServiceImpl.getScheduleTaskList(userid,new DateUtil().getNowFormat2());
    }

    @UserLoginToken
    @GetMapping("/getScheduleList/{userid}")
    @ApiOperation("获取每日任务列表")
    public List<ScheduleBO> getScheduleList(@PathVariable("userid")  int userid) {
        return scheduleServiceImpl.getScheduleList(userid);
    }

    @PostMapping("/addSchedule")
    @ApiOperation("添加每日任务")
    public Boolean addSchedule(@RequestBody ScheduleBO scheduleBO) {
        scheduleBO.setUserid(1);
        scheduleBO.setUpdateTime(new DateUtil().getNowFormat2());
        scheduleBO.setCreateTime(new DateUtil().getNowFormat2());
        scheduleBO.setCreateName("admin");
        scheduleBO.setUpdateName("admin");
        log.info(String.valueOf(scheduleBO));
        return scheduleServiceImpl.addSchedule(scheduleBO);
    }

    @PostMapping("/addScheduleTask")
    @ApiOperation("添加每日任务列表")
    public Boolean addScheduleTask(@RequestBody ScheduleTaskBO scheduleTaskBO) {
        log.info(String.valueOf(scheduleTaskBO));
        return scheduleServiceImpl.addScheduleTask(scheduleTaskBO);
    }

    @GetMapping("/updateScheduleTaskStatus/{taskid}")
    @ApiOperation("更新任务状态")
    public Boolean updateScheduleTaskStatus(@PathVariable("taskid") int taskid) throws MessagingException {
        log.info(String.valueOf(taskid));
        return scheduleServiceImpl.updateScheduleTaskStatus(taskid);
    }

    @GetMapping("/createScheduleTask")
    @ApiOperation("生成每日任务")
    public void createScheduleTask() throws MessagingException {
        scheduleTask.dailyScheduleTask();
    }
}
