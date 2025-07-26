package com.jacek.springboot.cruddemo.rest;

import com.jacek.springboot.cruddemo.dto.EmployeeDTO;
import com.jacek.springboot.cruddemo.dto.EmployeePatchDTO;
import com.jacek.springboot.cruddemo.model.Employee;
import com.jacek.springboot.cruddemo.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<Employee> addEmployee(@Valid @RequestBody EmployeeDTO employee){
        return new ResponseEntity<>(employeeService.add(employee), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Employee> getAllEmployees(){
        return employeeService.getAll();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id){
        return employeeService.getById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id,
                                                   @Valid @RequestBody EmployeeDTO employee){
        return ResponseEntity.ok(employeeService.update(id, employee));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id){
        employeeService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Employee> patchEmployee(@PathVariable Long id,
                                                  @Valid @RequestBody EmployeePatchDTO employee){

        return ResponseEntity.ok(employeeService.patch(id, employee));
    }
}

