package com.crm.bch.planifio.repository.workschedule.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "WORKSCHEDULE")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class WorkScheduleEntity {

    @Id
    @Column(columnDefinition = "varchar2(36)", nullable = false)
    private String id;

    // colonnes en VARCHAR2(5) dans Oracle
    @Column(name = "start_time", columnDefinition = "VARCHAR2(5)")
    private String startTimeStr;

    @Column(name = "end_time", columnDefinition = "VARCHAR2(5)")
    private String endTimeStr;

    @Column(columnDefinition = "integer", nullable = false)
    private int day;

    @Column(columnDefinition = "varchar2(36)", nullable = false)
    private String employeeID;

    @Transient
    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm");

    // ------------------- LocalTime getters/setters -------------------

    public LocalTime getStartTime() {
        return startTimeStr == null ? null : LocalTime.parse(startTimeStr, TIME_FORMATTER);
    }

    public void setStartTime(LocalTime startTime) {
        this.startTimeStr = startTime == null ? null : startTime.format(TIME_FORMATTER);
    }

    public LocalTime getEndTime() {
        return endTimeStr == null ? null : LocalTime.parse(endTimeStr, TIME_FORMATTER);
    }

    public void setEndTime(LocalTime endTime) {
        this.endTimeStr = endTime == null ? null : endTime.format(TIME_FORMATTER);
    }

}
