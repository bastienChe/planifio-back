package com.crm.bch.planifio.repository.employeePlanning;

import com.crm.bch.planifio.repository.employeePlanning.entities.EmployeePlanningEntity;

import java.util.List;

public interface EmployeePlanningDao {
    List<EmployeePlanningEntity> findEmployeePlanningByWeek(String employeeId, int weekNumber, int yearNumber);
}
