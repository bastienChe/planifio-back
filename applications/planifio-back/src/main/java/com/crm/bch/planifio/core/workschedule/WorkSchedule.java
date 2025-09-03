package com.crm.bch.planifio.core.workschedule;

import com.crm.bch.planifio.application.web.dto.Day;
import lombok.*;

import java.time.LocalTime;


@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class WorkSchedule {

    private String id;
    private LocalTime startTime;
    private LocalTime endTime;
    private Day day;
    private String employeeID;
    private int weekNumber;
    private int yearNumber;

}
