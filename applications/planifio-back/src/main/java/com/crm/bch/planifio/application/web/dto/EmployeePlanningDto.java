package com.crm.bch.planifio.application.web.dto;

import com.crm.bch.planifio.core.employeePlanning.EmployeePlanning;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class EmployeePlanningDto {

    private String id;
    private String employeeId;
    private String title;
    private int week;
    private int year;
    private Date startTime;
    private Date endTime;

    public EmployeePlanning toEmployeePlanning() {
        return new EmployeePlanning(
                this.getId(),
                this.getEmployeeId(),
                this.getTitle(),
                this.getWeek(),
                this.getYear(),
                this.getStartTime(),
                this.getEndTime()
        );
    }

    public static EmployeePlanningDto fromEmployeePlanning(EmployeePlanning employeePlanning) {
        return new EmployeePlanningDto(
                employeePlanning.getId(),
                employeePlanning.getEmployeeId(),
                employeePlanning.getTitle(),
                employeePlanning.getWeek(),
                employeePlanning.getYear(),
                employeePlanning.getStartTime(),
                employeePlanning.getEndTime()
        );
    }

}
