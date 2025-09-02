package com.crm.bch.planifio.application.web;

import com.crm.bch.planifio.application.web.dto.CustomerDto;
import com.crm.bch.planifio.core.customer.Customer;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CustomerDtoTest {

    @Test
    void toCustomer_shouldMapAllFieldsCorrectly() {
        CustomerDto dto = new CustomerDto(
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

        Customer customer = dto.toCustomer();

        assertThat(customer.getId()).isEqualTo("1");
        assertThat(customer.getFirstName()).isEqualTo("Hugo");
        assertThat(customer.getLastName()).isEqualTo("Dubois");
        assertThat(customer.getGender()).isEqualTo("M");
        assertThat(customer.getBirthDate()).isEqualTo("1989-12-30");
        assertThat(customer.getEmail()).isEqualTo("hugo.dubois@example.com");
        assertThat(customer.getPhone()).isEqualTo("0645871290");
        assertThat(customer.getAddress()).isEqualTo("99 rue des Lilas, Toulouse");
        assertThat(customer.getRegistrationDate()).isEqualTo("2021-06-20");
        assertThat(customer.getLastPurchaseDate()).isEqualTo("2023-10-15");
        assertThat(customer.getOrderCount()).isEqualTo(15);
        assertThat(customer.getTotalSpent()).isEqualTo(2450.0f);
        assertThat(customer.isOptinNewsletter()).isTrue();
        assertThat(customer.isOptinSms()).isFalse();
        assertThat(customer.getRating()).isEqualTo(3.5f);
    }

    @Test
    void fromCustomer_shouldMapAllFieldsCorrectly() {
        Customer customer = new Customer(
                "2",
                "Alice",
                "Martin",
                "F",
                "1990-01-01",
                "alice.martin@example.com",
                "0612345678",
                "10 rue de Paris, Lyon",
                "2020-01-01",
                "2022-05-10",
                7,
                999.9f,
                false,
                true,
                4.0f
        );

        CustomerDto dto = CustomerDto.fromCustomer(customer);

        assertThat(dto.getId()).isEqualTo("2");
        assertThat(dto.getFirstName()).isEqualTo("Alice");
        assertThat(dto.getLastName()).isEqualTo("Martin");
        assertThat(dto.getGender()).isEqualTo("F");
        assertThat(dto.getBirthDate()).isEqualTo("1990-01-01");
        assertThat(dto.getEmail()).isEqualTo("alice.martin@example.com");
        assertThat(dto.getPhone()).isEqualTo("0612345678");
        assertThat(dto.getAddress()).isEqualTo("10 rue de Paris, Lyon");
        assertThat(dto.getRegistrationDate()).isEqualTo("2020-01-01");
        assertThat(dto.getLastPurchaseDate()).isEqualTo("2022-05-10");
        assertThat(dto.getOrderCount()).isEqualTo(7);
        assertThat(dto.getTotalSpent()).isEqualTo(999.9f);
        assertThat(dto.isOptinNewsletter()).isFalse();
        assertThat(dto.isOptinSms()).isTrue();
        assertThat(dto.getRating()).isEqualTo(4.0f);
    }

    @Test
    void roundTripConversion_shouldPreserveValues() {
        CustomerDto original = new CustomerDto(
                "3",
                "Lucas",
                "Bernard",
                "M",
                "1985-07-20",
                "lucas.bernard@example.com",
                "0622334455",
                "5 avenue Victor Hugo, Marseille",
                "2019-03-01",
                "2024-01-01",
                20,
                5000.0f,
                true,
                true,
                5.0f
        );

        CustomerDto result = CustomerDto.fromCustomer(original.toCustomer());

        assertThat(result).isEqualTo(original);
    }
}
