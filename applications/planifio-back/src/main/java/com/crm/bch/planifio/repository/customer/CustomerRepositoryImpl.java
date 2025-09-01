package com.crm.bch.planifio.repository.customer;

import com.crm.bch.planifio.application.web.CustomerDto;
import com.crm.bch.planifio.core.customer.Customer;
import com.crm.bch.planifio.core.customer.CustomerRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Component
@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

    private final OracleCustomerDao dao;

    public CustomerRepositoryImpl(OracleCustomerDao dao) {
        this.dao = dao;
    }

    @Override
    public List<Customer> getCustomers() {
        return dao.findAll().stream().map(CustomerEntity::toCustomer).toList();
    }

    @Override
    public Optional<Customer> getCustomer(String id) {
        return dao.findById(id).map(CustomerEntity::toCustomer);
    }

    @Override
    public Customer createCustomer(Customer customer) {
        CustomerEntity customerEntity = dao.save(CustomerEntity.fromCustomer(customer));
        return customerEntity.toCustomer();
    }

}
