package com.crm.bch.planifio.application.web;

import com.crm.bch.planifio.application.web.dto.WorkScheduleDto;
import com.crm.bch.planifio.core.workschedule.WorkSchedule;
import com.crm.bch.planifio.core.workschedule.WorkScheduleManager;
import com.crm.bch.planifio.core.workschedule.WorkScheduleRepository;
import com.crm.bch.planifio.core.workschedule.exceptions.WorkScheduleNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("")
public class WorkScheduleController {

    private WorkScheduleManager workScheduleManager;

    public WorkScheduleController(WorkScheduleRepository workScheduleRepository) {
        this.workScheduleManager = new WorkScheduleManager(workScheduleRepository);
    }

    @GetMapping("/workschedules")
    public ResponseEntity<List<WorkScheduleDto>> getWorkSchedules() {
        List<WorkSchedule> workSchedules = workScheduleManager.getWorkSchedules();
        return ResponseEntity.ok(workSchedules.stream().map(WorkScheduleDto::fromWorkSchedule).toList());
    }

    @GetMapping("/employee/workschedule/{id}")
    public ResponseEntity<WorkScheduleDto> getWorkSchedule(@PathVariable String id) {
        try {
            WorkSchedule workSchedule = workScheduleManager.getWorkSchedule(id);
            return ResponseEntity.ok(WorkScheduleDto.fromWorkSchedule(workSchedule));
        } catch (WorkScheduleNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/employee/{employeeid}/workschedule/year/{yearnum}/week/{weeknum}")
    public ResponseEntity<List<WorkScheduleDto>> getWorkSchedule(@PathVariable String employeeid, @PathVariable int yearnum, @PathVariable int weeknum) {
        try {
            List<WorkSchedule> workSchedule = workScheduleManager.getWorkScheduleByEmployeeAndWeekNum(employeeid, yearnum, weeknum);
            return ResponseEntity.ok(workSchedule.stream().map(WorkScheduleDto::fromWorkSchedule).toList());
        } catch (WorkScheduleNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/workschedule")
    public ResponseEntity<WorkScheduleDto> setWorkSchedule(@RequestBody WorkScheduleDto workScheduleDto) {
        WorkSchedule createdWorkSchedule = workScheduleManager.createWorkSchedule(workScheduleDto.toWorkSchedule());
        return ResponseEntity.ok(WorkScheduleDto.fromWorkSchedule(createdWorkSchedule));
    }

    @PutMapping("/workschedule/{id}")
    public ResponseEntity<WorkScheduleDto> updateWorkSchedule(@PathVariable String id, @RequestBody WorkScheduleDto workScheduleDto) {
        try {
            workScheduleDto.setId(id);
            WorkSchedule updatedWorkSchedule = workScheduleManager.updateWorkSchedule(id, workScheduleDto.toWorkSchedule());
            return ResponseEntity.ok(WorkScheduleDto.fromWorkSchedule(updatedWorkSchedule));
        } catch (WorkScheduleNotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/workschedule/{id}")
    public ResponseEntity<String> removeWorkSchedule(@PathVariable String id) {
        workScheduleManager.deleteWorkSchedule(id);
        return ResponseEntity.ok("workSchedule "+id+" removed");
    }

}
