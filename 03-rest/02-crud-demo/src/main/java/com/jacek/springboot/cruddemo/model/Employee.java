package com.jacek.springboot.cruddemo.model;

import com.jacek.springboot.cruddemo.dto.EmployeeDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Employee {

    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String first_name;
    private String last_name;
    private String email;

    public Employee(String first_name, String last_name, String email){
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
    }
    public Employee(EmployeeDTO employee){
        this.first_name = employee.getFirst_name();
        this.last_name = employee.getLast_name();
        this.email = employee.getEmail();
    }
}
