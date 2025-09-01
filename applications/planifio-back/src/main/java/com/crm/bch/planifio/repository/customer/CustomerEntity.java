package com.crm.bch.planifio.repository.customer;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "REPORTING_DOMAINE")
public class CustomerEntity {

    @Id
    @Column(columnDefinition = "varchar2(32)", nullable = false)
    public String id;
}
