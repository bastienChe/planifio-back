package com.crm.bch.planifio.repository.customer;

import com.crm.bch.planifio.core.customer.Customer;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "CUSTOMER")
@Getter
@Setter
    @AllArgsConstructor
@NoArgsConstructor
public class CustomerEntity {

    @Id
    @Column(columnDefinition = "varchar2(36)", nullable = false)
    public String id;

    @Column(columnDefinition = "varchar2(15)", nullable = false)
    private String firstName;

    @Column(columnDefinition = "varchar2(30)", nullable = false)
    private String lastName;

    @Column(columnDefinition = "varchar2(1)")
    private String gender;

    @Column(columnDefinition = "varchar2(10)")
    private String birthDate;

    @Column(columnDefinition = "varchar2(40)", nullable = false)
    private String email;

    @Column(columnDefinition = "varchar2(13)")
    private String phone;

    @Column(columnDefinition = "varchar2(100)")
    private String address;

    @Column(columnDefinition = "varchar2(13)", nullable = false)
    private String registrationDate;

    @Column(columnDefinition = "varchar2(13)")
    private String lastPurchaseDate;

    @Column(columnDefinition = "integer", nullable = false)
    private int orderCount;

    @Column(columnDefinition = "decimal(6,2)", nullable = false)
    private float totalSpent;

    @Column(columnDefinition = "boolean", nullable = false)
    private boolean optinNewsletter;

    @Column(columnDefinition = "boolean", nullable = false)
    private boolean optinSms;

    @Column(columnDefinition = "decimal(2,1)", nullable = false)
    private float rating;


    public static CustomerEntity fromCustomer(Customer customer){
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


    public Customer toCustomer(){
        return new Customer(
            this.getId(),
            this.getFirstName(),
            this.getLastName(),
            this.getGender(),
            this.getBirthDate(),
            this.getEmail(),
            this.getPhone(),
            this.getAddress(),
            this.getRegistrationDate(),
            this.getLastPurchaseDate(),
            this.getOrderCount(),
            this.getTotalSpent(),
            this.isOptinNewsletter(),
            this.isOptinSms(),
            this.getRating()
        );
    }
}
