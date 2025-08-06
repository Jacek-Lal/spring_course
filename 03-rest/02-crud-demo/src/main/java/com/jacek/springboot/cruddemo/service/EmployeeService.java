package com.jacek.springboot.cruddemo.service;

import com.jacek.springboot.cruddemo.dto.EmployeeDTO;
import com.jacek.springboot.cruddemo.dto.EmployeePatchDTO;
import com.jacek.springboot.cruddemo.model.Employee;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

import java.util.List;

public interface EmployeeService {
    @Transactional
    Employee add(EmployeeDTO employee);

    List<Employee> getAll();

    Employee getById(Long id);

    @Transactional
    Employee update(Long id, EmployeeDTO updatedEmployee);

    @Transactional
    void delete(Long id);

    @Transactional
    Employee patch(Long id, @Valid EmployeePatchDTO updatedEmployee);
}
