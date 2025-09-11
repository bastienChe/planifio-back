package com.crm.bch.planifio.repository.customer;

import com.crm.bch.planifio.core.customer.Customer;
import com.crm.bch.planifio.core.customer.CustomerRepository;
import com.crm.bch.planifio.core.customer.exceptions.CustomerNotFoundException;
import com.crm.bch.planifio.repository.customer.entities.CustomerEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Slf4j
@Component
@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

    private final CustomerDao dao;

    public CustomerRepositoryImpl(CustomerDao dao) {
        this.dao = dao;
    }

    @Override
    public List<Customer> getCustomers() {
        return dao.findAll().stream().map(CustomerEntity::toCustomer).toList();
    }

    @Override
    public Optional<Customer> getCustomer(String id)  {
        return dao.findById(id).map(CustomerEntity::toCustomer);
    }

    @Override
    public Customer createCustomer(Customer customer) {
        customer.setId(java.util.UUID.randomUUID().toString());
        CustomerEntity customerEntity = dao.save(CustomerEntity.fromCustomer(customer));
        return customerEntity.toCustomer();
    }

    @Override
    public Customer updateCustomer(String id, Customer customer) {

        log.error(customer.getId());
        if (!dao.existsById(id)) {
            throw new CustomerNotFoundException(id);
        }
        CustomerEntity entity = CustomerEntity.fromCustomer(customer);
        log.error("entity" + entity.getId());
        return dao.save(entity).toCustomer();
    }

    @Override
    public void deleteCustomer(String id) {
        dao.deleteById(id);
    }

}
