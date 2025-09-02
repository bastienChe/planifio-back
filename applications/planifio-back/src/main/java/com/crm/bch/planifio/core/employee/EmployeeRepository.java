package com.crm.bch.planifio.core.employee;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository {
    List<Employee> getEmployees();

    Optional<Employee> getEmployee(String id);

    Employee createEmployee(Employee employee);

    Employee updateEmployee(String id, Employee employee);

    void deleteEmployee(String id);
}
