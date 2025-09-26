package com.crm.bch.planifio.repository.appointment;
import com.crm.bch.planifio.repository.appointment.entities.AppointmentEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AppointmentDao {
    AppointmentEntity save(AppointmentEntity employee);
}
