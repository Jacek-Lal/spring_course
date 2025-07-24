package com.jacek.springboot.demo.springboot_demo.rest;

import com.jacek.springboot.demo.springboot_demo.common.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DemoRestController {

    @GetMapping("/students")
    public List<Student> getStudents(){
        return List.of(
                new Student("Anna", "Nowak"),
                new Student("John", "Kozlo"),
                new Student("Jack", "Black")
        );
    }
}
