package com.crm.bch.planifio.repository.employee;

import com.crm.bch.planifio.core.employee.Employee;
import com.crm.bch.planifio.core.employee.EmployeeRepository;
import com.crm.bch.planifio.core.employee.exceptions.EmployeeNotFoundException;
import com.crm.bch.planifio.repository.employee.entities.EmployeeEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Slf4j
@Component
@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

    private final EmployeeDao dao;

    public EmployeeRepositoryImpl(EmployeeDao dao) {
        this.dao = dao;
    }

    @Override
    public List<Employee> getEmployees() {
        return dao.findAll().stream().map(EmployeeEntity::toEmployee).toList();
    }

    @Override
    public Optional<Employee> getEmployee(String id)  {
        return dao.findById(id).map(EmployeeEntity::toEmployee);
    }

    @Override
    public Employee createEmployee(Employee employee) {
        employee.setId(java.util.UUID.randomUUID().toString());
        EmployeeEntity employeeEntity = dao.save(EmployeeEntity.fromEmployee(employee));
        return employeeEntity.toEmployee();
    }

    @Override
    public Employee updateEmployee(String id, Employee employee) {

        log.error(employee.getId());
        if (!dao.existsById(id)) {
            throw new EmployeeNotFoundException(id);
        }
        EmployeeEntity entity = EmployeeEntity.fromEmployee(employee);
        log.error("entity" + entity.getId());
        return dao.save(entity).toEmployee();
    }

    @Override
    public void deleteEmployee(String id) {
        dao.deleteById(id);
    }

}
