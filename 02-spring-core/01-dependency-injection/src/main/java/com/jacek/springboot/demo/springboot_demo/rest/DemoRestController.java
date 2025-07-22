package com.jacek.springboot.demo.springboot_demo.rest;

import com.jacek.springboot.demo.springboot_demo.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoRestController {

    private final Coach myCoach;

    // Constructor injection
    @Autowired
    public DemoRestController(Coach coach){
        myCoach = coach;
    }

    // Setter injection
//    @Autowired
//    public void setCoach(Coach coach){
//        myCoach = coach;
//    }


    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }
}
