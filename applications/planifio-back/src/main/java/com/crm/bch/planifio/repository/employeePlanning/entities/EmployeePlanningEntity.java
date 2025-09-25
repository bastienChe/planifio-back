package com.crm.bch.planifio.repository.employeePlanning.entities;

import com.crm.bch.planifio.core.employeePlanning.EmployeePlanning;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "EMPLOYEE_PLANNING")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeePlanningEntity {

    @Id
    @Column(columnDefinition = "varchar2(36)", nullable = false)
    private String id;

    @Column(name = "employeeId", columnDefinition = "VARCHAR2(36)", nullable = false)
    private String employeeId;

    @Column(name = "title", columnDefinition = "VARCHAR2(30)", nullable = false)
    private String title;

    @Column(name = "week_number", columnDefinition = "integer", nullable = false)
    private int weekNumber;

    @Column(name = "year_number", columnDefinition = "integer", nullable = false)
    private int yearNumber;

    @Column(name = "start_time", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date startTime;

    @Column(name = "end_time", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date endTime;

    public static EmployeePlanningEntity fromEmployee(EmployeePlanning employeePlanning){
        return new EmployeePlanningEntity (
                employeePlanning.getId(),
                employeePlanning.getEmployeeId(),
                employeePlanning.getTitle(),
                employeePlanning.getWeek(),
                employeePlanning.getYear(),
                employeePlanning.getStartTime(),
                employeePlanning.getEndTime()
        );
    }

    public EmployeePlanning toEmployeePlanning(){
        return new EmployeePlanning(
                this.getId(),
                this.getEmployeeId(),
                this.getTitle(),
                this.getWeekNumber(),
                this.getYearNumber(),
                this.getStartTime(),
                this.getEndTime()
        );
    }
}
