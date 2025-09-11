package com.crm.bch.planifio.repository.workschedule;


import com.crm.bch.planifio.repository.workschedule.entities.WorkScheduleEntity;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.temporal.WeekFields;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Repository
@Profile("dev")
public class InMemoryWorkScheduleDao implements WorkScheduleDao {

    private final Map<String, WorkScheduleEntity> store = new ConcurrentHashMap<>();

    public InMemoryWorkScheduleDao() {
        // Jeu de données par défaut
        save(new WorkScheduleEntity("1", "09:00", "12:00", 0, "1", getCurrentWeek(), 2025));
        save(new WorkScheduleEntity("2", "13:00", "17:00", 0, "1", getCurrentWeek(), 2025));
        save(new WorkScheduleEntity("3", "08:30", "12:30", 1, "1", getCurrentWeek(), 2025));
        save(new WorkScheduleEntity("4", "14:00", "18:00", 2, "1", getCurrentWeek(), 2025));
        save(new WorkScheduleEntity("5", "08:00", "12:00", 4, "1", getCurrentWeek(), 2025));
        save(new WorkScheduleEntity("6", "14:00", "15:00", 4, "1", getCurrentWeek(), 2025));
        save(new WorkScheduleEntity("8", "16:00", "18:00", 4, "1", getCurrentWeek(), 2025));
        save(new WorkScheduleEntity("9", "14:00", "18:00", 5, "1", getCurrentWeek(), 2025));
        save(new WorkScheduleEntity("11", "10:00", "12:00", 0, "2", getCurrentWeek(), 2025));
        save(new WorkScheduleEntity("12", "13:00", "15:00", 0, "2", getCurrentWeek(), 2025));
        save(new WorkScheduleEntity("13", "16:30", "18:30", 1, "2", getCurrentWeek(), 2025));
        save(new WorkScheduleEntity("14", "09:00", "12:00", 2, "2", getCurrentWeek(), 2025));
        save(new WorkScheduleEntity("15", "08:00", "15:00", 4, "2", getCurrentWeek(), 2025));
        save(new WorkScheduleEntity("16", "16:00", "17:00", 4, "2", getCurrentWeek(), 2025));
    }

    @Override
    public List<WorkScheduleEntity> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public Optional<WorkScheduleEntity> findById(String id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public WorkScheduleEntity save(WorkScheduleEntity employee) {
        if (employee.getId() == null) {
            employee.setId(UUID.randomUUID().toString());
        }
        store.put(employee.getId(), employee);
        return employee;
    }

    @Override
    public boolean existsById(String id) {
        return store.containsKey(id);
    }

    @Override
    public void deleteById(String id) {
        store.remove(id);
    }

    private int getCurrentWeek() {
        LocalDate today = LocalDate.now();
        WeekFields weekFields = WeekFields.of(Locale.getDefault()); // utilise la locale (FR, US, etc.)
        return today.get(weekFields.weekOfWeekBasedYear());
    }
}
