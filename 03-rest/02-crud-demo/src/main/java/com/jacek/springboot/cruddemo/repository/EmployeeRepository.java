package com.jacek.springboot.cruddemo.repository;

import com.jacek.springboot.cruddemo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
