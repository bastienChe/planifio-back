package com.crm.bch.planifio.core.customer;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository {
    List<Customer> getCustomers();
}
