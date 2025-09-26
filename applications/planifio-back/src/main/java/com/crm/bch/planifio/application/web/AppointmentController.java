/*package com.crm.bch.planifio.application.web;

import com.crm.bch.planifio.application.web.dto.AppointmentDto;
import com.crm.bch.planifio.core.appointment.Appointment;
import com.crm.bch.planifio.core.appointment.AppointmentManager;
import com.crm.bch.planifio.core.appointment.AppointmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("")
@CrossOrigin(origins = "http://localhost:4200")
public class AppointmentController {

    private AppointmentManager appointmentManager;

    public AppointmentController(AppointmentRepository appointmentRepository) {
        this.appointmentManager = new AppointmentManager(appointmentRepository);
    }
/*
    @PostMapping("/take-appointment")
    public ResponseEntity<AppointmentDto> setAppointment(@RequestBody AppointmentDto appointmentDto) {
        Appointment createdAppointment = appointmentManager.setAppointment(appointmentDto.toAppointment());
        return ResponseEntity.ok(AppointmentDto.fromAppointment(createdAppointment));
    }*/

//}
