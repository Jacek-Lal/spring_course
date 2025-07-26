package com.jacek.springboot.cruddemo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class EmployeeRestExceptionHandler {

    @ExceptionHandler(value = EmployeeNotFoundException.class)
    public ResponseEntity<CustomErrorResponse> handleException(EmployeeNotFoundException ex){
        CustomErrorResponse error = new CustomErrorResponse();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(ex.getMessage());
        error.setTimestamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationErrors(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage()));

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<CustomErrorResponse> handleJsonContentErrors(HttpMessageNotReadableException ex) {
        return buildBadRequestError(ex.getMessage());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<CustomErrorResponse> handleBlankArguments(IllegalArgumentException ex) {
        return buildBadRequestError(ex.getMessage());
    }

    private ResponseEntity<CustomErrorResponse> buildBadRequestError(String message) {
        CustomErrorResponse error = new CustomErrorResponse();
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(message);
        error.setTimestamp(System.currentTimeMillis());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
