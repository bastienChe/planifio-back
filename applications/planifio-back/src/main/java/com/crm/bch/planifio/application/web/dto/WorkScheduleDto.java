package com.crm.bch.planifio.application.web.dto;

import com.crm.bch.planifio.core.workschedule.WorkSchedule;
import lombok.*;

import java.time.LocalTime;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class WorkScheduleDto {

    private String id;
    private LocalTime startTime;
    private LocalTime endTime;
    private Day day;
    private String employeeID;
    private int weekNumber;
    private int yearNumber;

    public WorkSchedule toWorkSchedule() {
        return new WorkSchedule(
            this.getId(),
            this.getStartTime(),
            this.getEndTime(),
            this.getDay(),
            this.getEmployeeID(),
            this.getWeekNumber(),
            this.getYearNumber()
        );
    }

    public static WorkScheduleDto fromWorkSchedule(WorkSchedule workSchedule) {
        return new WorkScheduleDto(
            workSchedule.getId(),
            workSchedule.getStartTime(),
            workSchedule.getEndTime(),
            workSchedule.getDay(),
            workSchedule.getEmployeeID(),
            workSchedule.getWeekNumber(),
            workSchedule.getYearNumber()
        );
    }

}
