package com.crm.bch.planifio.repository.customer;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "REPORTING_DOMAINE")
@AllArgsConstructor
public class CustomerEntity {

    @Id
    @Column(columnDefinition = "varchar2(32)", nullable = false)
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

    @Column(columnDefinition = "decimal(1,1)", nullable = false)
    private float rating;

}
