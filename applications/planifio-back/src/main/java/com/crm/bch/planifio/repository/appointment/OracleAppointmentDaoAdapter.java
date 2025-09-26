package com.crm.bch.planifio.repository.appointment;


import com.crm.bch.planifio.repository.appointment.entities.AppointmentEntity;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

@Repository
@Primary
@Profile("prod")
public class OracleAppointmentDaoAdapter implements AppointmentDao {

    private final OracleAppointmentDao jpaDao;

    public OracleAppointmentDaoAdapter(OracleAppointmentDao jpaDao) {
        this.jpaDao = jpaDao;
    }

    @Override
    public AppointmentEntity save(AppointmentEntity appointment) {
        return jpaDao.save(appointment);
    }
}