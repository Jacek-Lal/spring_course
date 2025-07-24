package com.jacek.springboot.demo.springboot_demo.rest;

public class StudentNotFoundException extends RuntimeException{
    public StudentNotFoundException(String message){
        super(message);
    }
}
