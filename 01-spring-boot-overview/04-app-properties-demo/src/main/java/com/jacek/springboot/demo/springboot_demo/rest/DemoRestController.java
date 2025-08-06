package com.jacek.springboot.demo.springboot_demo.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoRestController {

    // properties injection from app props file
    @Value("${user.name}")
    private String userName;

    @Value("${user.surname}")
    private String userSurname;

    @GetMapping("/")
    public String sayHello(){
        return String.format("Hello %s!", userName);
    }
}
