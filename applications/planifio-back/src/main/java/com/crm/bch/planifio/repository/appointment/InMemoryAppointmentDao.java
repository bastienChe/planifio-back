package com.crm.bch.planifio.repository.appointment;


import com.crm.bch.planifio.repository.appointment.entities.AppointmentEntity;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Repository
@Profile("dev")
public class InMemoryAppointmentDao implements AppointmentDao {

    private final Map<String, AppointmentEntity> store = new ConcurrentHashMap<>();

    public InMemoryAppointmentDao() {
    }

    @Override
    public AppointmentEntity save(AppointmentEntity employee) {
        return null;
    }
}
