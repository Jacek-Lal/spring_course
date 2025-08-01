package com.jacek.springboot.cruddemo.repository;

import com.jacek.springboot.cruddemo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(path = "members")
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
