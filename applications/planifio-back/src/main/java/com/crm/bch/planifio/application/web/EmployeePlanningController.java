package com.crm.bch.planifio.application.web;


import com.crm.bch.planifio.application.web.dto.AppointmentDto;
import com.crm.bch.planifio.application.web.dto.EmployeePlanningDto;
import com.crm.bch.planifio.core.appointment.Appointment;
import com.crm.bch.planifio.core.employeePlanning.EmployeePlanning;
import com.crm.bch.planifio.core.employeePlanning.EmployeePlanningManager;
import com.crm.bch.planifio.core.employeePlanning.EmployeePlanningRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("")
public class EmployeePlanningController {

    private EmployeePlanningManager employeePlanningManager;

    public EmployeePlanningController(EmployeePlanningRepository employeePlanningRepository) {
        this.employeePlanningManager = new EmployeePlanningManager(employeePlanningRepository);
    }

    @GetMapping("/employee/{employeeId}/planning/year/{yearNumber}/week/{weekNumber}")
    public ResponseEntity<List<EmployeePlanningDto>> findEmployeePlanningByWeek(@PathVariable String employeeId, @PathVariable int weekNumber, @PathVariable int yearNumber) {
        List<EmployeePlanning> employeePlanning = employeePlanningManager.findEmployeePlanningByWeek(employeeId, weekNumber, yearNumber);
        return ResponseEntity.ok(employeePlanning.stream().map(EmployeePlanningDto::fromEmployeePlanning).toList());
    }

    @PostMapping("/take-appointment")
    public ResponseEntity<EmployeePlanningDto> setAppointment(@RequestBody EmployeePlanningDto appointment) {
        EmployeePlanning createdAppointment = employeePlanningManager.setAppointment(appointment.toEmployeePlanning());
        return ResponseEntity.ok(EmployeePlanningDto.fromEmployeePlanning(createdAppointment));
    }

}
