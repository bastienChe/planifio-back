package com.crm.bch.planifio.repository.customer;

import com.crm.bch.planifio.core.customer.Customer;
import com.crm.bch.planifio.core.customer.CustomerRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Component
@Repository
public class CustomerRepositoryImpl implements CustomerRepository {
    @Override
    public List<Customer> getCustomers() {
        return List.of();
    }
}
