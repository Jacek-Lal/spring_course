package com.jacek.springboot.demo.springboot_demo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoRestController {

    @GetMapping("/hello")
    public String sayHello(){
        return "Hello World";
    }
}
