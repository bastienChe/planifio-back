package com.crm.bch.planifio.application.web;

import com.crm.bch.planifio.core.customer.Customer;
import com.crm.bch.planifio.core.customer.CustomerManager;
import com.crm.bch.planifio.core.customer.CustomerRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    private CustomerManager customerManager;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerManager = new CustomerManager(customerRepository);
    }

    @GetMapping("/customers")
    public List<CustomerDto> getCustomers() {
        List<Customer> customers = customerManager.getCustomers();
        return customers.stream().map(CustomerDto::toCustomerDto).toList();
    }

}
