package com.crm.bch.planifio.core.appointment;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentManager {

    private final AppointmentRepository appointmentRepository;

    public AppointmentManager(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public Appointment setAppointment(Appointment appointment) {
        return appointmentRepository.setAppointment(appointment);
    }

}
