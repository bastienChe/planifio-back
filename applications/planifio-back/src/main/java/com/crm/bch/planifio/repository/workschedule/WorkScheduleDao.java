package com.crm.bch.planifio.repository.workschedule;

import com.crm.bch.planifio.repository.workschedule.entities.WorkScheduleEntity;

import java.util.List;
import java.util.Optional;

public interface WorkScheduleDao {
    List<WorkScheduleEntity> findAll();
    Optional<WorkScheduleEntity> findById(String id);
    WorkScheduleEntity save(WorkScheduleEntity employee);
    boolean existsById(String id);
    void deleteById(String id);
}
