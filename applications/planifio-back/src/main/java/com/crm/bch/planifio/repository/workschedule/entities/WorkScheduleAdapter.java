package com.crm.bch.planifio.repository.workschedule.entities;
import com.crm.bch.planifio.application.web.dto.Day;
import com.crm.bch.planifio.core.workschedule.WorkSchedule;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class WorkScheduleAdapter {

    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm");

    public static WorkScheduleEntity fromWorkSchedule(WorkSchedule workSchedule) {
        if (workSchedule == null) return null;

        String startTimeStr = workSchedule.getStartTime() == null ? null
                : workSchedule.getStartTime().format(TIME_FORMATTER);
        String endTimeStr = workSchedule.getEndTime() == null ? null
                : workSchedule.getEndTime().format(TIME_FORMATTER);

        return new WorkScheduleEntity(
                workSchedule.getId(),
                startTimeStr,
                endTimeStr,
                workSchedule.getDay().getValue(),
                workSchedule.getEmployeeID()
        );
    }

    public static WorkSchedule toWorkSchedule(WorkScheduleEntity entity) {
        if (entity == null) return null;

        LocalTime startTime = entity.getStartTimeStr() == null ? null
                : LocalTime.parse(entity.getStartTimeStr(), TIME_FORMATTER);
        LocalTime endTime = entity.getEndTimeStr() == null ? null
                : LocalTime.parse(entity.getEndTimeStr(), TIME_FORMATTER);

        WorkSchedule workSchedule = new WorkSchedule();
        workSchedule.setId(entity.getId());
        workSchedule.setStartTime(startTime);
        workSchedule.setEndTime(endTime);
        workSchedule.setDay(Day.fromInt(entity.getDay())); // day est un int
        workSchedule.setEmployeeID(entity.getEmployeeID());

        return workSchedule;
    }
}
