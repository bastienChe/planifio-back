package com.crm.bch.planifio.core.workschedule;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WorkScheduleRepository {
    List<WorkSchedule> getWorkSchedules();

    Optional<WorkSchedule> getWorkSchedule(String id);

    WorkSchedule createWorkSchedule(WorkSchedule workSchedule);

    WorkSchedule updateWorkSchedule(String id, WorkSchedule workSchedule);

    void deleteWorkSchedule(String id);
}
