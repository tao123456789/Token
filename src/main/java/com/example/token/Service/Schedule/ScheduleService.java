package com.example.token.Service.Schedule;

import com.example.token.BO.schedule.ScheduleBO;
import com.example.token.BO.schedule.ScheduleTaskBO;

import java.util.List;

public interface ScheduleService {

    List<ScheduleBO> getScheduleList(int userid);
    List<ScheduleTaskBO> getScheduleTaskList(int userid, String startTime);
    Boolean addSchedule(ScheduleBO scheduleBO);
    Boolean addScheduleTask(ScheduleTaskBO scheduleTaskBO);
    Boolean updateScheduleTaskStatus(int taskid);
}
