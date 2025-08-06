package com.jacek.springboot.cruddemo.service;

import com.jacek.springboot.cruddemo.dto.EmployeeDTO;
import com.jacek.springboot.cruddemo.dto.EmployeePatchDTO;
import com.jacek.springboot.cruddemo.exceptions.EmployeeNotFoundException;
import com.jacek.springboot.cruddemo.model.Employee;
import com.jacek.springboot.cruddemo.repository.EmployeeRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Consumer;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
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

    public Employee patch(Long id, @Valid EmployeePatchDTO updatedEmployee) {
        Employee employee = getById(id);

        updateIfPresent(updatedEmployee.getFirst_name(), "First name", employee::setFirst_name);
        updateIfPresent(updatedEmployee.getLast_name(), "Last name", employee::setLast_name);
        updateIfPresent(updatedEmployee.getEmail(), "Email", employee::setEmail);

        return repository.save(employee);
    }

    private void updateIfPresent(String value, String fieldName, Consumer<String> setter){
        if(value != null){
            if (value.isBlank())
                throw new IllegalArgumentException(fieldName + " cannot be blank if provided");

            setter.accept(value);
        }
    }
}
