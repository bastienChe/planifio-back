package com.crm.bch.planifio.application.web.dto;

import com.crm.bch.planifio.core.employee.Employee;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {

    private String id;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String companyId;

    public Employee toEmployee() {
        return new Employee(
               this.getId(),
               this.getFirstName(),
               this.getLastName(),
                this.getPhone(),
                this.getEmail(),
                this.getCompanyId()
        );
    }

    public static EmployeeDto fromEmployee(Employee employee) {
        return new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getPhone(),
                employee.getEmail(),
                employee.getCompanyId()
        );
    }

}
