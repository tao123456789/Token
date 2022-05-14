package com.example.token.Service.Schedule;

import com.example.token.Entity.BO.schedule.ScheduleBO;
import com.example.token.Entity.BO.schedule.ScheduleTaskBO;

import javax.mail.MessagingException;
import java.util.List;

public interface ScheduleService {

    List<ScheduleBO> getScheduleList(int userid);
    List<ScheduleTaskBO> getScheduleTaskList(int userid, String startTime);
    Boolean addSchedule(ScheduleBO scheduleBO);
    Boolean addScheduleTask(ScheduleTaskBO scheduleTaskBO);
    Boolean updateScheduleTaskStatus(int taskid) throws Exception;
}
