package com.crm.bch.planifio.application.web;

import com.crm.bch.planifio.core.customer.Customer;
import com.crm.bch.planifio.core.customer.CustomerManager;
import com.crm.bch.planifio.core.customer.CustomerRepository;
import com.crm.bch.planifio.core.customer.exceptions.CustomerNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    private CustomerManager customerManager;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerManager = new CustomerManager(customerRepository);
    }

    @GetMapping("/customers")
    public ResponseEntity<List<CustomerDto>> getCustomers() {
        List<Customer> customers = customerManager.getCustomers();
        return ResponseEntity.ok(customers.stream().map(CustomerDto::fromCustomer).toList());
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<CustomerDto> getCustomer(@PathVariable String id) {
        try {
            Customer customer = customerManager.getCustomer(id);
            return ResponseEntity.ok(CustomerDto.fromCustomer(customer));
        } catch (CustomerNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/customer")
    public ResponseEntity<CustomerDto> setCustomer(@RequestBody CustomerDto customerDto) {
        Customer createdCustomer = customerManager.createCustomer(customerDto.toCustomer());
        return ResponseEntity.ok(CustomerDto.fromCustomer(createdCustomer));
    }

    @PutMapping("/customer/{id}")
    public CustomerDto updateCustomer(@PathVariable String id, @RequestBody CustomerDto customerDto) {
        Customer customer = customerDto.toCustomer();
        return customerManager.updateCustomer(id, customer);
    }

    @DeleteMapping("/customer/{id}")
    public CustomerDto removeCustomer(@PathVariable String id) {
        Customer customer = customerManager.removeCustomer(id);
        return CustomerDto.fromCustomer(customer);
    }

}
