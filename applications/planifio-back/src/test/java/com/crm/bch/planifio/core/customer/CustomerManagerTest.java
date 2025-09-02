package com.crm.bch.planifio.core.customer;

import com.crm.bch.planifio.core.customer.exceptions.CustomerNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.*;

public class CustomerManagerTest {

    @Mock
    private CustomerRepository customerRepository;

    private CustomerManager customerManager;

    private Customer customer;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
        customerManager = new CustomerManager(customerRepository);

        customer = new Customer(
                "1",
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
    }

    @Test
    void getCustomers_shouldReturnList() {
        when(customerRepository.getCustomers()).thenReturn(List.of(customer));

        List<Customer> customers = customerManager.getCustomers();

        assertThat(customers).hasSize(1).containsExactly(customer);
        verify(customerRepository, times(1)).getCustomers();
    }

    @Test
    void getCustomer_shouldReturnCustomer_whenFound() {
        when(customerRepository.getCustomer("1")).thenReturn(Optional.of(customer));

        Customer result = customerManager.getCustomer("1");

        assertThat(result).isEqualTo(customer);
        verify(customerRepository, times(1)).getCustomer("1");
    }

    @Test
    void getCustomer_shouldThrow_whenNotFound() {
        when(customerRepository.getCustomer("999")).thenReturn(Optional.empty());

        assertThatThrownBy(() -> customerManager.getCustomer("999"))
                .isInstanceOf(CustomerNotFoundException.class)
                .hasMessage("Customer not found with id: 999");

        verify(customerRepository, times(1)).getCustomer("999");
    }

    @Test
    void createCustomer_shouldCallRepository() {
        when(customerRepository.createCustomer(customer)).thenReturn(customer);

        Customer result = customerManager.createCustomer(customer);

        assertThat(result).isEqualTo(customer);
        verify(customerRepository, times(1)).createCustomer(customer);
    }

    @Test
    void updateCustomer_shouldCallRepository() {
        when(customerRepository.updateCustomer("1", customer)).thenReturn(customer);

        Customer result = customerManager.updateCustomer("1", customer);

        assertThat(result).isEqualTo(customer);
        verify(customerRepository, times(1)).updateCustomer("1", customer);
    }

    @Test
    void deleteCustomer_shouldCallRepository() {
        doNothing().when(customerRepository).deleteCustomer("1");

        customerManager.deleteCustomer("1");

        verify(customerRepository, times(1)).deleteCustomer("1");
    }
}
