package com.crm.bch.planifio.repository.customer;

import com.crm.bch.planifio.repository.customer.entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OracleCustomerDao extends JpaRepository<CustomerEntity, String> {

}
