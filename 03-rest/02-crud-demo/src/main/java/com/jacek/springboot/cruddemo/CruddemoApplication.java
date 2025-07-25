package com.jacek.springboot.cruddemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}


	// update database config in application.properties
	// create employee entity
	// create DAO (Repository) interface
	// create DAO (Repository) implementation
	// Create REST controller to use DAO (Repository)
	// add methods to:
		// CREATE NEW EMPLOYEE (POST)
		// READ LIST OF EMPLOYEES (GET)
		// READ A SINGLE EMPLOYEE BY ID (GET)
		// UPDATE EXISTING EMPLOYEE (PUT)
		// DELETE EXISTING EMPLOYEE (DELETE)
}
