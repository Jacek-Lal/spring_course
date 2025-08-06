package com.jacek.springboot.demo.springboot_demo.rest;

import com.jacek.springboot.demo.springboot_demo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoRestController {

    private final Coach myCoach;

    // Qualifier annotation overrides Primary annotation
    @Autowired
    public DemoRestController(@Qualifier("cricketCoach") Coach coach){
        myCoach = coach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }
}
