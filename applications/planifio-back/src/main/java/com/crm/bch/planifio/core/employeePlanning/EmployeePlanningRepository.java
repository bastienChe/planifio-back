package com.crm.bch.planifio.core.employeePlanning;

import com.crm.bch.planifio.core.employee.Employee;
import com.crm.bch.planifio.repository.employeePlanning.entities.EmployeePlanningEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeePlanningRepository {
    List<EmployeePlanning> findEmployeePlanningByWeek(String employeeId, int weekNumber, int yearNumber);

    EmployeePlanning setAppointment(EmployeePlanningEntity employeePlanningEntity);
}
