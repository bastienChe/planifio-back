package com.crm.bch.planifio.repository.appointment;

import com.crm.bch.planifio.repository.appointment.entities.AppointmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OracleAppointmentDao extends JpaRepository<AppointmentEntity, String> {

}
