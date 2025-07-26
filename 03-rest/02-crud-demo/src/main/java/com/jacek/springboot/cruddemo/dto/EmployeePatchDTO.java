package com.jacek.springboot.cruddemo.dto;

import jakarta.validation.constraints.Email;
import lombok.Data;

@Data
public class EmployeePatchDTO {
    private String first_name;
    private String last_name;

    @Email(message = "Email must be in valid format")
    private String email;
}
