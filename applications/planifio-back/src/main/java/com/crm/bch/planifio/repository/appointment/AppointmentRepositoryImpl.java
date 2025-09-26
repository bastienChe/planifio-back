package com.crm.bch.planifio.repository.appointment;

import com.crm.bch.planifio.core.appointment.Appointment;
import com.crm.bch.planifio.core.appointment.AppointmentRepository;
import com.crm.bch.planifio.repository.appointment.entities.AppointmentAdapter;
import com.crm.bch.planifio.repository.employeePlanning.EmployeePlanningDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Slf4j
@Component
@Repository
public class AppointmentRepositoryImpl implements AppointmentRepository {

    private final AppointmentDao dao;

    public AppointmentRepositoryImpl(AppointmentDao dao) {
        this.dao = dao;
    }

    @Override
    public Appointment setAppointment(Appointment appointment) {
        return AppointmentAdapter.toAppointment(dao.save(AppointmentAdapter.fromAppointment(appointment)));
    }
}
