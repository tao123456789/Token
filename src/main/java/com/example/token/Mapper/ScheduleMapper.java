package com.example.token.Mapper;

import com.example.token.BO.schedule.ScheduleTaskBO;
import org.apache.ibatis.annotations.Param;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface ScheduleMapper {
    List<ScheduleTaskBO> getScheduleList(@Param("userid") int userid);
    List<ScheduleTaskBO> getScheduleTaskList(@Param("userid") int userid, @Param("startTime") String startTime);
    Boolean addSchedule(ScheduleTaskBO scheduleTaskBO);
    Boolean addScheduleTask(ScheduleTaskBO scheduleTaskBO);
    Boolean updateScheduleTaskStatus(int taskid);
}
