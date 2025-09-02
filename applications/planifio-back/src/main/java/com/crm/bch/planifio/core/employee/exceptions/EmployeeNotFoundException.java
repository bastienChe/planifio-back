package com.crm.bch.planifio.core.employee.exceptions;

public class EmployeeNotFoundException extends RuntimeException {

    private final String employeeId;

    public EmployeeNotFoundException(String employeeId) {
        super("Employee not found with id: " + employeeId);
        this.employeeId = employeeId;
    }

    public String getEmployeeId() {
        return employeeId;
    }
}