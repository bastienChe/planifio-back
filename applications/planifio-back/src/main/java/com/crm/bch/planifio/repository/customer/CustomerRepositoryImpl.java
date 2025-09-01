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

    public CustomerEntity toCustomerEntity(Customer customer){
        return new CustomerEntity(
                customer.getId(),
                customer.getFirstName(),
                customer.getLastName(),
                customer.getGender(),
                customer.getBirthDate(),
                customer.getEmail(),
                customer.getPhone(),
                customer.getAddress(),
                customer.getRegistrationDate(),
                customer.getLastPurchaseDate(),
                customer.getOrderCount(),
                customer.getTotalSpent(),
                customer.isOptinNewsletter(),
                customer.isOptinSms(),
                customer.getRating()
        );
    }
}
