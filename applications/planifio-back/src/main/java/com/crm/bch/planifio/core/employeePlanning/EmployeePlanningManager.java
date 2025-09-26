package com.crm.bch.planifio.core.employeePlanning;

import com.crm.bch.planifio.repository.appointment.entities.AppointmentEntity;
import com.crm.bch.planifio.repository.employeePlanning.entities.EmployeePlanningEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeePlanningManager {

    private final EmployeePlanningRepository employeePlanningRepository;

    public EmployeePlanningManager(EmployeePlanningRepository employeeRepository) {
        this.employeePlanningRepository = employeeRepository;
    }

    public List<EmployeePlanning> findEmployeePlanningByWeek(String employeeId, int weekNumber, int yearNumber) {
        return employeePlanningRepository.findEmployeePlanningByWeek(employeeId, weekNumber, yearNumber);
    }

    public EmployeePlanning setAppointment(EmployeePlanning appointment) {
        return employeePlanningRepository.setAppointment(EmployeePlanningEntity.fromEmployee(appointment));
    }
}
