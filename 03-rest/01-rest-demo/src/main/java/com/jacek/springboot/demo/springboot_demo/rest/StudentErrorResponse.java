package com.jacek.springboot.demo.springboot_demo.rest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StudentErrorResponse {
    private int status;
    private String message;
    private long timestamp;
}
