package com.crm.bch.planifio.repository.workschedule;

import com.crm.bch.planifio.core.workschedule.WorkSchedule;
import com.crm.bch.planifio.core.workschedule.WorkScheduleRepository;
import com.crm.bch.planifio.core.workschedule.exceptions.WorkScheduleNotFoundException;
import com.crm.bch.planifio.repository.workschedule.entities.WorkScheduleAdapter;
import com.crm.bch.planifio.repository.workschedule.entities.WorkScheduleEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Slf4j
@Component
@Repository
public class WorkcheduleRepositoryImpl implements WorkScheduleRepository {

    private final OracleWorkScheduleDao dao;

    public WorkcheduleRepositoryImpl(OracleWorkScheduleDao dao) {
        this.dao = dao;
    }

    @Override
    public List<WorkSchedule> getWorkSchedules() {
        return dao.findAll().stream().map(WorkScheduleAdapter::toWorkSchedule).toList();
    }

    @Override
    public Optional<WorkSchedule> getWorkSchedule(String id)  {
        return dao.findById(id).map(WorkScheduleAdapter::toWorkSchedule);
    }

    @Override
    public List<WorkSchedule> getWorkScheduleByEmployeeAndWeekNum(String employeeid, int yearNumber, int weekNum) {
        return dao.getWorkScheduleByWeekNum(employeeid, yearNumber, weekNum).stream().map(WorkScheduleAdapter::toWorkSchedule).toList();
    }

    @Override
    public WorkSchedule createWorkSchedule(WorkSchedule workSchedule) {
        workSchedule.setId(java.util.UUID.randomUUID().toString());
        WorkScheduleEntity workScheduleEntity = dao.save(WorkScheduleAdapter.fromWorkSchedule(workSchedule));
        return WorkScheduleAdapter.toWorkSchedule(workScheduleEntity);
    }

    @Override
    public WorkSchedule updateWorkSchedule(String id, WorkSchedule workSchedule) {

        if (!dao.existsById(id)) {
            throw new WorkScheduleNotFoundException(id);
        }

        WorkScheduleEntity entity = WorkScheduleAdapter.fromWorkSchedule(workSchedule);
        WorkScheduleEntity saved = dao.save(entity);
        return WorkScheduleAdapter.toWorkSchedule(saved);
    }

    @Override
    public void deleteWorkSchedule(String id) {
        dao.deleteById(id);
    }

}
