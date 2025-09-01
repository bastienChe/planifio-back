package com.crm.bch.planifio.core.customer;

import lombok.*;


@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

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

}
