package com.crm.bch.planifio.repository.customer;


import com.crm.bch.planifio.repository.customer.entities.CustomerEntity;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Repository
@Profile("dev")
public class InMemoryCustomerDao implements CustomerDao {

    private final Map<String, CustomerEntity> store = new ConcurrentHashMap<>();

    public InMemoryCustomerDao() {
        // Jeu de données par défaut
        save(new CustomerEntity("c1", "Alice", "Martin", "F", "1990-05-12", "alice.martin@example.com", "0612345678", "12 rue de Paris, Lyon", "2023-10-15", "2021-06-20", 15, 2450, true, false, (float) Math.floor(Math.random() * 5)));
        save(new CustomerEntity("c2", "Bob", "Durand", "M", "1985-03-22", "bob.durand@example.com", "0698765432", "34 avenue de la République, Marseille", "2023-10-15", "2021-06-20", 15, 2450, false, true, (float) Math.floor(Math.random() * 5)));
        save(new CustomerEntity("c3","Chloé","Bernard","F","1992-11-08","chloe.bernard@example.com","0678452391","56 boulevard Saint-Michel, Paris","2023-10-15","2021-06-20",15,2450,true,true,(float) Math.floor(Math.random() * 5)));
        save(new CustomerEntity("c4","David","Petit","M","1978-02-14","david.petit@example.com","0625123498","3 rue Victor Hugo, Bordeaux","2023-10-15","2021-06-20",15,2450,false,false,(float) Math.floor(Math.random() * 5)));
        save(new CustomerEntity("c5","Emma","Lefevre","F","2000-07-01","emma.lefevre@example.com","0667458192","27 avenue des Fleurs, Nice","2023-10-15","2021-06-20",15,2450,true,false,(float) Math.floor(Math.random() * 5)));
        save(new CustomerEntity("c6","François","Moreau","M","1983-09-19","francois.moreau@example.com","0634895721","78 chemin des Oliviers, Montpellier","2023-10-15","2021-06-20",15,2450,false,true,(float) Math.floor(Math.random() * 5)));
        save(new CustomerEntity("c7","Gaëlle","Roux","F","1995-04-23","gaelle.roux@example.com","0698123475","14 rue de la Gare, Nantes","2023-10-15","2021-06-20",15,2450,true,true,(float) Math.floor(Math.random() * 5)));
        save(new CustomerEntity("c8","Hugo","Dubois","M","1989-12-30","hugo.dubois@example.com","0645871290","99 rue des Lilas, Toulouse","2023-10-15","2021-06-20",15,2450,false,false,(float) Math.floor(Math.random() * 5)));
    }

    @Override
    public List<CustomerEntity> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public Optional<CustomerEntity> findById(String id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public CustomerEntity save(CustomerEntity employee) {
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
