package com.example.token.Api.Schedule;

import com.example.token.Entity.BO.schedule.ScheduleBO;
import com.example.token.Entity.BO.schedule.ScheduleTaskBO;
import com.example.token.Config.Interface.UserLoginToken;
import com.example.token.Service.Schedule.Impl.ScheduleServiceImpl;
import com.example.token.Service.Schedule.Schedule.ScheduleTask;
import com.example.token.Utils.date.DateUtil;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@UserLoginToken
@Slf4j
@RestController
@RequestMapping("/DailySchedule")
public class ScheduleController {

    @Autowired
    private ScheduleServiceImpl scheduleService;

    @Autowired
    ScheduleTask scheduleTask;

    @UserLoginToken
    @GetMapping("/getScheduleTaskList/{userid}")
    @ApiOperation("获取每日任务列表")
    public List<ScheduleTaskBO> getScheduleTaskList(@PathVariable("userid")  int userid) {
        return scheduleService.getScheduleTaskList(userid,new DateUtil().getNowFormat2());
    }

    @UserLoginToken
    @GetMapping("/getScheduleList/{userid}")
    @ApiOperation("获取每日任务列表")
    public List<ScheduleBO> getScheduleList(@PathVariable("userid")  int userid) {
        return scheduleService.getScheduleList(userid);
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
        return scheduleService.addSchedule(scheduleBO);
    }

    @PostMapping("/addScheduleTask")
    @ApiOperation("添加每日任务列表")
    public Boolean addScheduleTask(@RequestBody ScheduleTaskBO scheduleTaskBO) {
        log.info(String.valueOf(scheduleTaskBO));
        return scheduleService.addScheduleTask(scheduleTaskBO);
    }

    @GetMapping("/updateScheduleTaskStatus/{taskid}")
    @ApiOperation("更改任务状态")
    public Boolean updateScheduleTaskStatus(@PathVariable("taskid") int taskid) {
        log.info(String.valueOf(taskid));
        return scheduleService.updateScheduleTaskStatus(taskid);
    }

    @GetMapping("/createScheduleTask")
    @ApiOperation("生成每日任务")
    public void createScheduleTask(){
        scheduleTask.scheduleTask();
    }
}
