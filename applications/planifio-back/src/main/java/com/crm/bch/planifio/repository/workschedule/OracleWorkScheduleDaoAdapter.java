package com.crm.bch.planifio.repository.workschedule;

import com.crm.bch.planifio.repository.workschedule.entities.WorkScheduleEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class OracleWorkScheduleDaoAdapter implements WorkScheduleDao {

    private final OracleWorkScheduleDao jpaDao;

    public OracleWorkScheduleDaoAdapter(OracleWorkScheduleDao jpaDao) {
        this.jpaDao = jpaDao;
    }

    @Override
    public List<WorkScheduleEntity> findAll() {
        return jpaDao.findAll();
    }

    @Override
    public Optional<WorkScheduleEntity> findById(String id) {
        return jpaDao.findById(id);
    }

    @Override
    public WorkScheduleEntity save(WorkScheduleEntity employee) {
        return jpaDao.save(employee);
    }

    @Override
    public boolean existsById(String id) {
        return jpaDao.existsById(id);
    }

    @Override
    public void deleteById(String id) {
        jpaDao.deleteById(id);
    }
}