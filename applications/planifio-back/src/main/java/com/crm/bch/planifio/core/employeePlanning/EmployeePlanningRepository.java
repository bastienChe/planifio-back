package com.crm.bch.planifio.core.employeePlanning;

import com.crm.bch.planifio.core.employee.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeePlanningRepository {
    List<EmployeePlanning> getEmployeeWeekPlanning(String employeeId, int weekNumber, int yearNumber);

}
