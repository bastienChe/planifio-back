package com.crm.bch.planifio.core.customer;

import com.crm.bch.planifio.application.web.CustomerDto;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository {
    List<Customer> getCustomers();

    Optional<Customer> getCustomer(String id);

    Customer createCustomer(Customer customer);
}
