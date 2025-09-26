package com.crm.bch.planifio.repository.appointment.entities;

import com.crm.bch.planifio.core.appointment.Appointment;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class AppointmentAdapter {

    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm");

    public static AppointmentEntity fromAppointment(Appointment appointment) {
        if (appointment == null) return null;

        String startTimeStr = appointment.getStartTime() == null ? null
                : appointment.getStartTime().format(TIME_FORMATTER);
        String endTimeStr = appointment.getEndTime() == null ? null
                : appointment.getEndTime().format(TIME_FORMATTER);

        return new AppointmentEntity(
                appointment.getId(),
                startTimeStr,
                endTimeStr,
                appointment.getEmployeeID(),
                appointment.getWeekNumber(),
                appointment.getYearNumber()
        );
    }

    public static Appointment toAppointment(AppointmentEntity entity) {
        if (entity == null) return null;

        LocalTime startTime = entity.getStartTimeStr() == null ? null
                : LocalTime.parse(entity.getStartTimeStr(), TIME_FORMATTER);
        LocalTime endTime = entity.getEndTimeStr() == null ? null
                : LocalTime.parse(entity.getEndTimeStr(), TIME_FORMATTER);

        Appointment appointment = new Appointment();
        appointment.setId(entity.getId());
        appointment.setStartTime(startTime);
        appointment.setEndTime(endTime);
        appointment.setEmployeeID(entity.getEmployeeID());
        appointment.setWeekNumber(entity.getWeekNumber());
        appointment.setYearNumber(entity.getYearNumber());

        return appointment;
    }
}
