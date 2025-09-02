package com.crm.bch.planifio.core.employee;

import com.crm.bch.planifio.core.employee.exceptions.EmployeeNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeManager {

    private final EmployeeRepository employeeRepository;

    public EmployeeManager(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getEmployees() {
        return employeeRepository.getEmployees();
    }

    public Employee getEmployee(String id) {
       return employeeRepository.getEmployee(id).orElseThrow(() -> new EmployeeNotFoundException(id));
    }

    public Employee createEmployee(Employee employee) {
        return employeeRepository.createEmployee(employee);
    }

    public Employee updateEmployee(String id, Employee employee) {
        return employeeRepository.updateEmployee(id, employee);
    }

    public void deleteEmployee(String id) {
        employeeRepository.deleteEmployee(id);
    }
}
