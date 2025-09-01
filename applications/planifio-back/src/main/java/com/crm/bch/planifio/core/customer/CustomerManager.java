package com.crm.bch.planifio.core.customer;

import com.crm.bch.planifio.application.web.CustomerDto;
import com.crm.bch.planifio.core.customer.exceptions.CustomerNotFoundException;
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

    public Customer getCustomer(String id) {
       return customerRepository.getCustomer(id).orElseThrow(() -> new CustomerNotFoundException(id));

    }

    public Customer createCustomer(Customer customer) {
        return customerRepository.createCustomer(customer);
    }
}
