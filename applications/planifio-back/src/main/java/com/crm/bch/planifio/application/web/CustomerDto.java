package com.crm.bch.planifio.application.web;

import com.crm.bch.planifio.core.customer.Customer;

public class CustomerDto {

    public static CustomerDto toCustomerDto(Customer customer) {
        return new CustomerDto();
    }

}
