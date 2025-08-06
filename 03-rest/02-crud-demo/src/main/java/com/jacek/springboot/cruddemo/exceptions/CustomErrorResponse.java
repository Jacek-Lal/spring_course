package com.jacek.springboot.cruddemo.exceptions;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CustomErrorResponse {
    private int status;
    private String message;
    private long timestamp;
}
