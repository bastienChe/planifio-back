package com.crm.bch.planifio.repository.employee;


import com.crm.bch.planifio.repository.employee.entities.EmployeeEntity;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Primary
@Profile("prod")
public class OracleEmployeeDaoAdapter implements EmployeeDao {

    private final OracleEmployeeDao jpaDao;

    public OracleEmployeeDaoAdapter(OracleEmployeeDao jpaDao) {
        this.jpaDao = jpaDao;
    }

    @Override
    public List<EmployeeEntity> findAll() {
        return jpaDao.findAll();
    }

    @Override
    public Optional<EmployeeEntity> findById(String id) {
        return jpaDao.findById(id);
    }

    @Override
    public EmployeeEntity save(EmployeeEntity employee) {
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