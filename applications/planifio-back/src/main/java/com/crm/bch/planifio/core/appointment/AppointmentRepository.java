package com.crm.bch.planifio.core.appointment;

import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository {
    Appointment setAppointment(Appointment appointment);
}
