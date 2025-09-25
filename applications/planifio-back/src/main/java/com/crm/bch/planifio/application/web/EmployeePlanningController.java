package com.crm.bch.planifio.application.web;


import com.crm.bch.planifio.application.web.dto.EmployeePlanningDto;
import com.crm.bch.planifio.core.employeePlanning.EmployeePlanning;
import com.crm.bch.planifio.core.employeePlanning.EmployeePlanningManager;
import com.crm.bch.planifio.core.employeePlanning.EmployeePlanningRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("")
public class EmployeePlanningController {

    private EmployeePlanningManager employeePlanningManager;

    public EmployeePlanningController(EmployeePlanningRepository employeePlanningRepository) {
        this.employeePlanningManager = new EmployeePlanningManager(employeePlanningRepository);
    }

    @GetMapping("/employee/{id}/planning/year/{yearNumber}/week/{weekNumber}")
    public ResponseEntity<List<EmployeePlanningDto>> getEmployeeWeekPlanning(String employeeId, int weekNumber, int yearNumber) {
        List<EmployeePlanning> employeePlanning = employeePlanningManager.getEmployeeWeekPlanning(employeeId, weekNumber, yearNumber);
        return ResponseEntity.ok(employeePlanning.stream().map(EmployeePlanningDto::fromEmployeePlanning).toList());
    }

}
