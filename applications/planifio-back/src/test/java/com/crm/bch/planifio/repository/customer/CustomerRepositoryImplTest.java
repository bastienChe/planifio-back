package com.crm.bch.planifio.repository.customer;

import com.crm.bch.planifio.core.customer.Customer;
import com.crm.bch.planifio.core.customer.exceptions.CustomerNotFoundException;
import com.crm.bch.planifio.repository.customer.entities.CustomerEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.*;

public class CustomerRepositoryImplTest {

    @Mock
    private CustomerDao dao;

    private CustomerRepositoryImpl repository;

    private Customer customer;
    private CustomerEntity customerEntity;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
        repository = new CustomerRepositoryImpl(dao);

        customer = new Customer(
                null,
                "Hugo",
                "Dubois",
                "M",
                "1989-12-30",
                "hugo.dubois@example.com",
                "0645871290",
                "99 rue des Lilas, Toulouse",
                "2021-06-20",
                "2023-10-15",
                15,
                2450.0f,
                true,
                false,
                3.5f
        );

        customerEntity = CustomerEntity.fromCustomer(customer);
    }

    @Test
    void getCustomers_shouldReturnList() {
        when(dao.findAll()).thenReturn(List.of(customerEntity));

        List<Customer> result = repository.getCustomers();

        assertThat(result).hasSize(1);
        assertThat(result.get(0).getFirstName()).isEqualTo("Hugo");
        verify(dao, times(1)).findAll();
    }

    @Test
    void getCustomer_shouldReturnCustomer_whenFound() {
        when(dao.findById("1")).thenReturn(Optional.of(customerEntity));

        Optional<Customer> result = repository.getCustomer("1");

        assertThat(result).isPresent();
        assertThat(result.get().getFirstName()).isEqualTo("Hugo");
        verify(dao, times(1)).findById("1");
    }

    @Test
    void getCustomer_shouldReturnEmpty_whenNotFound() {
        when(dao.findById("999")).thenReturn(Optional.empty());

        Optional<Customer> result = repository.getCustomer("999");

        assertThat(result).isEmpty();
        verify(dao, times(1)).findById("999");
    }

    @Test
    void createCustomer_shouldGenerateIdAndSave() {
        when(dao.save(any(CustomerEntity.class))).thenAnswer(invocation -> {
            CustomerEntity arg = invocation.getArgument(0);
            arg.setId("generated-id"); // simule la DB
            return arg;
        });

        Customer result = repository.createCustomer(customer);

        assertThat(result.getId()).isNotNull();
        assertThat(result.getFirstName()).isEqualTo("Hugo");
        verify(dao, times(1)).save(any(CustomerEntity.class));
    }

    @Test
    void updateCustomer_shouldUpdate_whenExists() {
        customer.setId("1");
        when(dao.existsById("1")).thenReturn(true);
        when(dao.save(any(CustomerEntity.class))).thenReturn(CustomerEntity.fromCustomer(customer));

        Customer result = repository.updateCustomer("1", customer);

        assertThat(result.getId()).isEqualTo("1");
        verify(dao, times(1)).existsById("1");
        verify(dao, times(1)).save(any(CustomerEntity.class));
    }

    @Test
    void updateCustomer_shouldThrow_whenNotExists() {
        when(dao.existsById("999")).thenReturn(false);

        assertThatThrownBy(() -> repository.updateCustomer("999", customer))
                .isInstanceOf(CustomerNotFoundException.class)
                .hasMessage("Customer not found with id: 999");

        verify(dao, times(1)).existsById("999");
        verify(dao, never()).save(any(CustomerEntity.class));
    }

    @Test
    void deleteCustomer_shouldCallDaoDelete() {
        doNothing().when(dao).deleteById("1");

        repository.deleteCustomer("1");

        verify(dao, times(1)).deleteById("1");
    }
}
