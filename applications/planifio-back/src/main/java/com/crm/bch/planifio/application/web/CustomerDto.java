package com.crm.bch.planifio.application.web;

import com.crm.bch.planifio.core.customer.Customer;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {

    private String id;
    private String firstName;
    private String lastName;
    private String gender;
    private String birthDate;
    private String email;
    private String phone;
    private String address;
    private String registrationDate;
    private String lastPurchaseDate;
    private int orderCount;
    private float totalSpent;
    private boolean optinNewsletter;
    private boolean optinSms;
    private float rating;

    public static CustomerDto toCustomerDto(Customer customer) {
        return new CustomerDto(
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
