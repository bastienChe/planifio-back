package com.crm.bch.planifio.repository.employee;
import com.crm.bch.planifio.repository.employee.entities.EmployeeEntity;

import java.util.List;
import java.util.Optional;

public interface EmployeeDao {
    List<EmployeeEntity> findAll();
    Optional<EmployeeEntity> findById(String id);
    EmployeeEntity save(EmployeeEntity employee);
    boolean existsById(String id);
    void deleteById(String id);
}
