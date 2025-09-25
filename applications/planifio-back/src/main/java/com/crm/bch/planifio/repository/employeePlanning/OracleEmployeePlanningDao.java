package com.crm.bch.planifio.repository.employeePlanning;

import com.crm.bch.planifio.repository.employeePlanning.entities.EmployeePlanningEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OracleEmployeePlanningDao extends JpaRepository<EmployeePlanningEntity, String> {

}
