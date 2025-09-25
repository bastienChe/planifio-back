package com.crm.bch.planifio.repository.customer;
import com.crm.bch.planifio.repository.customer.entities.CustomerEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerDao {
    List<CustomerEntity> findAll();
    Optional<CustomerEntity> findById(String id);
    CustomerEntity save(CustomerEntity employee);
    boolean existsById(String id);
    void deleteById(String id);
}
