package com.crm.bch.planifio.repository.employeePlanning;


import com.crm.bch.planifio.repository.employeePlanning.entities.EmployeePlanningEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.temporal.WeekFields;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Repository
@Slf4j
@Profile("dev")
public class InMemoryEmployeePlanningDao implements EmployeePlanningDao {

    private final Map<String, EmployeePlanningEntity> store = new ConcurrentHashMap<>();

    public InMemoryEmployeePlanningDao() {
        LocalDate today = LocalDate.now();
        ZoneId zone = ZoneId.systemDefault(); // fuseau horaire système
        this.store.put("1", new EmployeePlanningEntity("1","1","rdv TOM", getActualWeek(), getActualYear(),
                Date.from(LocalDateTime.of(today, LocalTime.of(9, 0)).atZone(zone).toInstant()),
                Date.from(LocalDateTime.of(today, LocalTime.of(9, 30)).atZone(zone).toInstant())));
        this.store.put("2", new EmployeePlanningEntity("2","1","rdv X", getActualWeek(), getActualYear(),
                Date.from(LocalDateTime.of(today, LocalTime.of(10, 0)).atZone(zone).toInstant()),
                Date.from(LocalDateTime.of(today, LocalTime.of(11, 30)).atZone(zone).toInstant())));
        this.store.put("3", new EmployeePlanningEntity("3","1","rdv D", getActualWeek(), getActualYear(),
                Date.from(LocalDateTime.of(today, LocalTime.of(14, 0)).atZone(zone).toInstant()),
                Date.from(LocalDateTime.of(today, LocalTime.of(14, 30)).atZone(zone).toInstant())));
        this.store.put("4", new EmployeePlanningEntity("4","2","rdv E", getActualWeek(), getActualYear(),
                Date.from(LocalDateTime.of(today, LocalTime.of(9, 0)).atZone(zone).toInstant()),
                Date.from(LocalDateTime.of(today, LocalTime.of(9, 30)).atZone(zone).toInstant())));
    }

    @Override
    public List<EmployeePlanningEntity> findEmployeePlanningByWeek(String employeeId, int weekNumber, int yearNumber) {
        List<EmployeePlanningEntity> employeePlanningByWeek = store.values().stream()
                .filter(e -> e.getWeekNumber() == weekNumber)
                .filter(e -> e.getYearNumber() == yearNumber)
                .filter(e -> e.getEmployeeId().equals(employeeId))
                .toList();
        return employeePlanningByWeek;
    }

    @Override
    public EmployeePlanningEntity setAppointment(EmployeePlanningEntity employeePlanningEntity) {
        String nextval = String.valueOf(this.store.size());
        this.store.put(nextval, employeePlanningEntity);
        return this.store.get(nextval);
    }

    private int getActualWeek() {
        LocalDate today = LocalDate.now();
        WeekFields weekFields = WeekFields.of(Locale.getDefault());
        log.error(String.valueOf(today.get(weekFields.weekOfWeekBasedYear())));
        return today.get(weekFields.weekOfWeekBasedYear());
    }

    private int getActualYear() {
        LocalDate today = LocalDate.now();
        WeekFields weekFields = WeekFields.of(Locale.getDefault());
        return today.get(weekFields.weekBasedYear());
    }
}
