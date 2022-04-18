package com.example.token.Api.Schedule;

import com.example.token.BO.schedule.ScheduleTaskBO;
import com.example.token.Config.Interface.UserLoginToken;
import com.example.token.Service.Schedule.Impl.ScheduleServiceImpl;
import com.example.token.util.date.DateUtil;
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

    @UserLoginToken
    @GetMapping("/getScheduleTaskList/{userid}")
    @ApiOperation("获取每日任务列表")
    public List<ScheduleTaskBO> getScheduleTaskList(@PathVariable("userid")  int userid) {
        return scheduleService.getScheduleTaskList(userid,new DateUtil().getNowFormat1());
    }

    @UserLoginToken
    @GetMapping("/getScheduleList/{userid}")
    @ApiOperation("获取每日任务列表")
    public List<ScheduleTaskBO> getScheduleList(@PathVariable("userid")  int userid) {
        return scheduleService.getScheduleList(userid);
    }

    @PostMapping("/addSchedule")
    @ApiOperation("添加每日任务")
    public Boolean addSchedule(@RequestBody ScheduleTaskBO scheduleTaskBO) {
        log.info(String.valueOf(scheduleTaskBO));
        return scheduleService.addSchedule(scheduleTaskBO);
    }

    @PostMapping("/addScheduleTask")
    @ApiOperation("添加每日任务列表")
    public Boolean addScheduleTask(@RequestBody ScheduleTaskBO scheduleTaskBO) {
        log.info(String.valueOf(scheduleTaskBO));
        return scheduleService.addSchedule(scheduleTaskBO);
    }

    @PostMapping("/updateScheduleTaskStatus/{taskid}")
    @ApiOperation("更改任务状态")
    public Boolean updateScheduleTaskStatus(@RequestBody int taskid) {
        log.info(String.valueOf(taskid));
        return scheduleService.updateScheduleTaskStatus(taskid);
    }
}
