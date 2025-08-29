package com.crm.bch.planifio.core.customer;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerManager {

    private final CustomerRepository customerRepository;

    public CustomerManager(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getCustomers() {
        return customerRepository.getCustomers();
    }
}
