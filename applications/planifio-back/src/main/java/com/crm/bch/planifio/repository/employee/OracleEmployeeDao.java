package com.crm.bch.planifio.repository.employee;

import com.crm.bch.planifio.repository.employee.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OracleEmployeeDao extends JpaRepository<EmployeeEntity, String> {

}
