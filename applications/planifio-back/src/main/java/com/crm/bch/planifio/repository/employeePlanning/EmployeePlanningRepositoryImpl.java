package com.crm.bch.planifio.repository.employeePlanning;

import com.crm.bch.planifio.core.employeePlanning.EmployeePlanning;
import com.crm.bch.planifio.core.employeePlanning.EmployeePlanningRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@Component
@Repository
public class EmployeePlanningRepositoryImpl implements EmployeePlanningRepository {

    private final EmployeePlanningDao dao;

    public EmployeePlanningRepositoryImpl(EmployeePlanningDao dao) {
        this.dao = dao;
    }

    @Override
    public List<EmployeePlanning> getEmployeeWeekPlanning(String employeeId, int weekNumber, int yearNumber) {
        return List.of();
    }
}
