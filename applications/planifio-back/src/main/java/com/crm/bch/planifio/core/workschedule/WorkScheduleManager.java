package com.crm.bch.planifio.core.workschedule;

import com.crm.bch.planifio.core.workschedule.exceptions.WorkScheduleNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkScheduleManager {

    private final WorkScheduleRepository workScheduleRepository;

    public WorkScheduleManager(WorkScheduleRepository workScheduleRepository) {
        this.workScheduleRepository = workScheduleRepository;
    }

    public List<WorkSchedule> getWorkSchedules() {
        return workScheduleRepository.getWorkSchedules();
    }

    public WorkSchedule getWorkSchedule(String id) {
       return workScheduleRepository.getWorkSchedule(id).orElseThrow(() -> new WorkScheduleNotFoundException(id));
    }

    public WorkSchedule createWorkSchedule(WorkSchedule workSchedule) {
        return workScheduleRepository.createWorkSchedule(workSchedule);
    }

    public WorkSchedule updateWorkSchedule(String id, WorkSchedule workSchedule) {
        return workScheduleRepository.updateWorkSchedule(id, workSchedule);
    }

    public void deleteWorkSchedule(String id) {
        workScheduleRepository.deleteWorkSchedule(id);
    }

    public List<WorkSchedule> getWorkScheduleByWeekNum(int year, int weekNum) {
        return workScheduleRepository.getWorkScheduleByWeekNum(year, weekNum);
    }
}
