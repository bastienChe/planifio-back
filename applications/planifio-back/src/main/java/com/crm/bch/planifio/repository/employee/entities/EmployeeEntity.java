package com.crm.bch.planifio.repository.employee.entities;

import com.crm.bch.planifio.core.employee.Employee;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "EMPLOYEE")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeEntity {

    @Id
    @Column(columnDefinition = "varchar2(36)", nullable = false)
    public String id;

    @Column(columnDefinition = "varchar2(15)", nullable = false)
    private String firstName;

    @Column(columnDefinition = "varchar2(30)", nullable = false)
    private String lastName;

    @Column(columnDefinition = "varchar2(13)", nullable = false)
    private String phone;

    @Column(columnDefinition = "varchar2(30)", nullable = false)
    private String email;

    @Column(columnDefinition = "varchar2(36)", nullable = false)
    private String companyId;

    public static EmployeeEntity fromEmployee(Employee employee){
        return new EmployeeEntity(
            employee.getId(),
            employee.getFirstName(),
            employee.getLastName(),
            employee.getPhone(),
            employee.getEmail(),
            employee.getCompanyId()
        );
    }


    public Employee toEmployee(){
        return new Employee(
            this.getId(),
            this.getFirstName(),
            this.getLastName(),
            this.getPhone(),
            this.getEmail(),
            this.getCompanyId()
        );
    }
}
