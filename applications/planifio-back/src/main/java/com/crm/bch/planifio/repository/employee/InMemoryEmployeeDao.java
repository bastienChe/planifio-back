package com.crm.bch.planifio.repository.employee;


import com.crm.bch.planifio.repository.employee.entities.EmployeeEntity;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Repository
@Profile("dev")
public class InMemoryEmployeeDao implements EmployeeDao {

    private final Map<String, EmployeeEntity> store = new ConcurrentHashMap<>();

    public InMemoryEmployeeDao() {
        // Jeu de données par défaut
        save(new EmployeeEntity("1", "Hugo", "Dubois", "0612345678", "hugo.dubois@example.com", "COMP1"));
        save(new EmployeeEntity("2", "Alice", "Martin", "0623456789", "alice.martin@example.com", "COMP1"));
        save(new EmployeeEntity("3", "Lucas", "Bernard", "0634567890", "lucas.bernard@example.com", "COMP2"));
        save(new EmployeeEntity("4", "Emma", "Petit", "0645678901", "emma.petit@example.com", "COMP2"));
        save(new EmployeeEntity("5", "Léo", "Robert", "0656789012", "leo.robert@example.com", "COMP2"));
        save(new EmployeeEntity("6", "Chloé", "Richard", "0667890123", "chloe.richard@example.com", "COMP1"));
        save(new EmployeeEntity("7", "Nathan", "Durand", "0678901234", "nathan.durand@example.com", "COMP1"));
        save(new EmployeeEntity("8", "Sophie", "Moreau", "0689012345", "sophie.moreau@example.com", "COMP1"));
        save(new EmployeeEntity("9", "Gabriel", "Fournier", "0690123456", "gabriel.fournier@example.com", "COMP1"));
        save(new EmployeeEntity("10", "Manon", "Girard", "0701234567", "manon.girard@example.com", "COMP1"));
    }

    @Override
    public List<EmployeeEntity> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public Optional<EmployeeEntity> findById(String id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public EmployeeEntity save(EmployeeEntity employee) {
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
}
