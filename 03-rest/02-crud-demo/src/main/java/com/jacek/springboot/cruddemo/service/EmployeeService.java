package com.jacek.springboot.cruddemo.service;

import com.jacek.springboot.cruddemo.dto.EmployeeDTO;
import com.jacek.springboot.cruddemo.exceptions.EmployeeNotFoundException;
import com.jacek.springboot.cruddemo.model.Employee;
import com.jacek.springboot.cruddemo.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository repository;

    public Employee add(EmployeeDTO employee){
        return repository.save(new Employee(employee));
    }
    public List<Employee> getAll(){
        return repository.findAll();
    }
    public Employee getById(Long id){
        return repository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee with id "+id+" not found"));
    }
    public Employee update(Long id, EmployeeDTO updatedEmployee){
        Employee employee = getById(id);
        employee.setFirst_name(updatedEmployee.getFirst_name());
        employee.setLast_name(updatedEmployee.getLast_name());
        employee.setEmail(updatedEmployee.getEmail());

        return repository.save(employee);
    }
    public void delete(Long id){
        Employee employee = getById(id);
        repository.delete(employee);
    }
}
