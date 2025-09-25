package com.crm.bch.planifio.repository.employeePlanning;


import com.crm.bch.planifio.repository.employeePlanning.entities.EmployeePlanningEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Repository
@Slf4j
@Profile("dev")
public class InMemoryEmployeePlanningDao implements EmployeePlanningDao {

    private final Map<String, EmployeePlanningEntity> store = new ConcurrentHashMap<>();

    public InMemoryEmployeePlanningDao() {
    }

    @Override
    public List<EmployeePlanningEntity> findEmployeePlanningByWeek(String employeeId, int weekNumber, int yearNumber) {
        return List.of();
    }
}
