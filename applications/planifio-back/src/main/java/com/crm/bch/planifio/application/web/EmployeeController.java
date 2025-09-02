package com.crm.bch.planifio.application.web;

import com.crm.bch.planifio.application.web.dto.EmployeeDto;
import com.crm.bch.planifio.core.employee.Employee;
import com.crm.bch.planifio.core.employee.EmployeeManager;
import com.crm.bch.planifio.core.employee.EmployeeRepository;
import com.crm.bch.planifio.core.employee.exceptions.EmployeeNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("")
public class EmployeeController {

    private EmployeeManager employeeManager;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeManager = new EmployeeManager(employeeRepository);
    }

    @GetMapping("/employees")
    public ResponseEntity<List<EmployeeDto>> getEmployees() {
        List<Employee> employees = employeeManager.getEmployees();
        return ResponseEntity.ok(employees.stream().map(EmployeeDto::fromEmployee).toList());
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<EmployeeDto> getEmployee(@PathVariable String id) {
        try {
            Employee employee = employeeManager.getEmployee(id);
            return ResponseEntity.ok(EmployeeDto.fromEmployee(employee));
        } catch (EmployeeNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/employee")
    public ResponseEntity<EmployeeDto> setEmployee(@RequestBody EmployeeDto employeeDto) {
        Employee createdEmployee = employeeManager.createEmployee(employeeDto.toEmployee());
        return ResponseEntity.ok(EmployeeDto.fromEmployee(createdEmployee));
    }

    @PutMapping("/employee/{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable String id, @RequestBody EmployeeDto employeeDto) {
        try {
            employeeDto.setId(id);
            Employee updatedEmployee = employeeManager.updateEmployee(id, employeeDto.toEmployee());
            return ResponseEntity.ok(EmployeeDto.fromEmployee(updatedEmployee));
        } catch (EmployeeNotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/employee/{id}")
    public ResponseEntity<String> removeEmployee(@PathVariable String id) {
        employeeManager.deleteEmployee(id);
        return ResponseEntity.ok("employee "+id+" removed");
    }

}
