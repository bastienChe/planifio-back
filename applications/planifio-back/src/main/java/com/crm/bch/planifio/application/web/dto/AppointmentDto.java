package com.crm.bch.planifio.application.web.dto;

import com.crm.bch.planifio.core.appointment.Appointment;
import lombok.*;

import java.time.LocalTime;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentDto {

    private String id;
    private LocalTime startTime;
    private LocalTime endTime;
    private String employeeID;
    private int weekNumber;
    private int yearNumber;

    public Appointment toAppointment() {
        return new Appointment(
            this.getId(),
            this.getStartTime(),
            this.getEndTime(),
            this.getEmployeeID(),
            this.getWeekNumber(),
            this.getYearNumber()
        );
    }

    public static AppointmentDto fromAppointment(Appointment appointment) {
        return new AppointmentDto(
            appointment.getId(),
            appointment.getStartTime(),
            appointment.getEndTime(),
            appointment.getEmployeeID(),
            appointment.getWeekNumber(),
            appointment.getYearNumber()
        );
    }

}
