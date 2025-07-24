package com.jacek.springboot.demo.springboot_demo.rest;

import com.jacek.springboot.demo.springboot_demo.common.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DemoRestController {
    private List<Student> students;

    @PostConstruct
    public void loadData(){
         students = List.of(
                new Student("Anna", "Nowak"),
                new Student("John", "Kozlo"),
                new Student("Jack", "Black")
        );
    }

    @GetMapping("/students")
    public List<Student> getStudents(){
        return students;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){
        if(studentId < 0 || studentId > students.size() - 1)
            throw new RuntimeException("Incorect student id");

        return students.get(studentId);
    }
}
