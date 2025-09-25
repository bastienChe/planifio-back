/*package com.crm.bch.planifio.application.web;

import com.crm.bch.planifio.core.customer.Customer;
import com.crm.bch.planifio.core.customer.CustomerManager;
import com.crm.bch.planifio.core.customer.CustomerRepository;
import com.crm.bch.planifio.core.customer.exceptions.CustomerNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = CustomerController.class,
        excludeAutoConfiguration = {
                org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class,
                org.springframework.boot.autoconfigure.security.servlet.SecurityFilterAutoConfiguration.class
        })
class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CustomerRepository repository;

    private CustomerManager customerManager;

    private Customer customerNotCreated;

    private Customer existingCustomer;

    @BeforeEach
    void setup() {
        customerManager = new CustomerManager(repository);
        existingCustomer = new Customer("1", "Hugo", "Dubois", "M", "1989-12-30", "hugo.dubois@example.com", "0645871290", "99 rue des Lilas, Toulouse","2023-10-15", "2021-06-20", 15, 2450, false, false,   Double.valueOf("2.5").floatValue());
        customerNotCreated = new Customer(null, "Hugo", "Dubois", "M", "1989-12-30", "hugo.dubois@example.com", "0645871290", "99 rue des Lilas, Toulouse", "2023-10-15", "2021-06-20", 15, 2450,  false, false, Double.valueOf("2.5").floatValue());
    }

    @Test
    void getCustomers_shouldReturnList() throws Exception {

        when(repository.getCustomers()).thenReturn(List.of(existingCustomer));

        mockMvc.perform(get("/customers"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value("1"))
                .andExpect(jsonPath("$[0].firstName").value("Hugo"))
                .andExpect(jsonPath("$[0].email").value("hugo.dubois@example.com"));
    }

    @Test
    void getCustomer_shouldReturnCustomer_whenFound() throws Exception {
        when(repository.getCustomer("1")).thenReturn(Optional.of(existingCustomer));

        mockMvc.perform(get("/customer/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value("1"))
                .andExpect(jsonPath("$.firstName").value("Hugo"))
                .andExpect(jsonPath("$.email").value("hugo.dubois@example.com"));
    }

    @Test
    void getCustomer_shouldReturn404_whenNotFound() throws Exception {
        when(repository.getCustomer("999")).thenReturn(Optional.empty());

        mockMvc.perform(get("/customer/999"))
                .andExpect(status().isNotFound());
    }

    @Test
    void setCustomer_shouldCreateCustomer() throws Exception {
        when(repository.createCustomer(any(Customer.class))).thenReturn(existingCustomer);

        String json = """
                {
                  "firstName": "Hugo",
                  "lastName": "Dubois",
                  "gender": "M",
                  "birthDate": "1989-12-30",
                  "email": "hugo.dubois@example.com",
                  "phone": "0645871290",
                  "address": "99 rue des Lilas, Toulouse",
                  "optinNewsletter": false,
                  "optinSms": false,
                  "lastPurchaseDate": "2023-10-15",
                  "registrationDate": "2021-06-20",
                  "orderCount": 15,
                  "totalSpent": 2450,
                  "rating": 2.5
                }
                """;

        mockMvc.perform(post("/customer")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value("1"))
                .andExpect(jsonPath("$.firstName").value("Hugo"));
    }

    @Test
    void updateCustomer_shouldReturnUpdatedCustomer_whenFound() throws Exception {
        existingCustomer.setFirstName("TEST");
        when(repository.getCustomer(eq("1"))).thenReturn(Optional.of(existingCustomer));
        when(repository.updateCustomer(eq("1"), any(Customer.class))).thenReturn(existingCustomer);

        String json = """
                {
                  "firstName": "TEST",
                  "lastName": "Dubois",
                  "gender": "M",
                  "birthDate": "1989-12-30",
                  "email": "hugo.dubois@example.com",
                  "phone": "0645871290",
                  "address": "99 rue des Lilas, Toulouse",
                  "optinNewsletter": false,
                  "optinSms": false,
                  "lastPurchaseDate": "2023-10-15",
                  "registrationDate": "2021-06-20",
                  "orderCount": 15,
                  "totalSpent": 2450,
                  "rating": 2.5
                }
                """;

        mockMvc.perform(put("/customer/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value("1"))
                .andExpect(jsonPath("$.firstName").value("TEST"));
    }

    @Test
    void updateCustomer_shouldReturn404_whenNotFound() throws Exception {
        when(repository.updateCustomer(eq("999"), any(Customer.class))).thenThrow(CustomerNotFoundException.class);

        String json = """
                {
                  "id": "999",
                  "firstName": "Hugo",
                  "lastName": "Dubois",
                  "gender": "M",
                  "birthDate": "1989-12-30",
                  "email": "hugo.dubois@example.com",
                  "phone": "0645871290",
                  "address": "99 rue des Lilas, Toulouse",
                  "optinNewsletter": false,
                  "optinSms": false,
                  "lastPurchaseDate": "2023-10-15",
                  "registrationDate": "2021-06-20",
                  "orderCount": 15,
                  "totalSpent": 2450,
                  "rating": 2.5
                }
                """;

        mockMvc.perform(put("/customer/999")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isNotFound());
    }

    @Test
    void removeCustomer_shouldReturnConfirmation() throws Exception {
        mockMvc.perform(delete("/customer/1"))
                .andExpect(status().isOk())
                .andExpect(content().string("customer 1 removed"));
    }
}
*/