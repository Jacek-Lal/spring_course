package com.jacek.springboot.cruddemo.repository;

import com.jacek.springboot.cruddemo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
