package com.crm.bch.planifio.repository.employeePlanning;


import com.crm.bch.planifio.core.employeePlanning.EmployeePlanning;
import com.crm.bch.planifio.repository.employeePlanning.entities.EmployeePlanningEntity;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Primary
@Profile("prod")
public class OracleEmployeePlanningDaoAdapter implements EmployeePlanningDao {

    private final OracleEmployeePlanningDao jpaDao;

    public OracleEmployeePlanningDaoAdapter(OracleEmployeePlanningDao jpaDao) {
        this.jpaDao = jpaDao;
    }

    @Override
    public List<EmployeePlanningEntity> findEmployeePlanningByWeek(String employeeId, int weekNumber, int yearNumber) {
        return List.of();
    }

    @Override
    public EmployeePlanningEntity setAppointment(EmployeePlanningEntity employeePlanningEntity) {
        return null;
    }
}