package com.crm.bch.planifio.repository.customer;

import com.crm.bch.planifio.core.customer.Customer;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CustomerEntityTest {
    @Test
    void fromCustomer_shouldMapAllFieldsCorrectly() {
        Customer customer = new Customer(
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

        CustomerEntity entity = CustomerEntity.fromCustomer(customer);

        assertThat(entity.getId()).isEqualTo("1");
        assertThat(entity.getFirstName()).isEqualTo("Hugo");
        assertThat(entity.getLastName()).isEqualTo("Dubois");
        assertThat(entity.getGender()).isEqualTo("M");
        assertThat(entity.getBirthDate()).isEqualTo("1989-12-30");
        assertThat(entity.getEmail()).isEqualTo("hugo.dubois@example.com");
        assertThat(entity.getPhone()).isEqualTo("0645871290");
        assertThat(entity.getAddress()).isEqualTo("99 rue des Lilas, Toulouse");
        assertThat(entity.getRegistrationDate()).isEqualTo("2021-06-20");
        assertThat(entity.getLastPurchaseDate()).isEqualTo("2023-10-15");
        assertThat(entity.getOrderCount()).isEqualTo(15);
        assertThat(entity.getTotalSpent()).isEqualTo(2450.0f);
        assertThat(entity.isOptinNewsletter()).isTrue();
        assertThat(entity.isOptinSms()).isFalse();
        assertThat(entity.getRating()).isEqualTo(3.5f);
    }

    @Test
    void toCustomer_shouldMapAllFieldsCorrectly() {
        CustomerEntity entity = new CustomerEntity(
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

        Customer customer = entity.toCustomer();

        assertThat(customer.getId()).isEqualTo("2");
        assertThat(customer.getFirstName()).isEqualTo("Alice");
        assertThat(customer.getLastName()).isEqualTo("Martin");
        assertThat(customer.getGender()).isEqualTo("F");
        assertThat(customer.getBirthDate()).isEqualTo("1990-01-01");
        assertThat(customer.getEmail()).isEqualTo("alice.martin@example.com");
        assertThat(customer.getPhone()).isEqualTo("0612345678");
        assertThat(customer.getAddress()).isEqualTo("10 rue de Paris, Lyon");
        assertThat(customer.getRegistrationDate()).isEqualTo("2020-01-01");
        assertThat(customer.getLastPurchaseDate()).isEqualTo("2022-05-10");
        assertThat(customer.getOrderCount()).isEqualTo(7);
        assertThat(customer.getTotalSpent()).isEqualTo(999.9f);
        assertThat(customer.isOptinNewsletter()).isFalse();
        assertThat(customer.isOptinSms()).isTrue();
        assertThat(customer.getRating()).isEqualTo(4.0f);
    }

    @Test
    void roundTripConversion_shouldPreserveValues() {
        Customer customer = new Customer(
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

        CustomerEntity entity = CustomerEntity.fromCustomer(customer);
        Customer result = entity.toCustomer();

        assertThat(result).isEqualTo(customer);
    }
}
