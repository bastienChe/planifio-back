package com.crm.bch.planifio.repository.customer;


import com.crm.bch.planifio.repository.customer.entities.CustomerEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class OracleCustomerDaoAdapter implements CustomerDao {

    private final OracleCustomerDao jpaDao;

    public OracleCustomerDaoAdapter(OracleCustomerDao jpaDao) {
        this.jpaDao = jpaDao;
    }

    @Override
    public List<CustomerEntity> findAll() {
        return jpaDao.findAll();
    }

    @Override
    public Optional<CustomerEntity> findById(String id) {
        return jpaDao.findById(id);
    }

    @Override
    public CustomerEntity save(CustomerEntity employee) {
        return jpaDao.save(employee);
    }

    @Override
    public boolean existsById(String id) {
        return jpaDao.existsById(id);
    }

    @Override
    public void deleteById(String id) {
        jpaDao.deleteById(id);
    }
}