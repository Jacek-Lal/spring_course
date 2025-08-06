package com.jacek.springboot.demo.springboot_demo.rest;

import com.jacek.springboot.demo.springboot_demo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoRestController {

    private final Coach myCoach;
    private final Coach anotherCoach;
    private final Coach yetAnotherCoach;

    // Qualifier annotation overrides Primary annotation
    @Autowired
    public DemoRestController(@Qualifier("cricketCoach") Coach coach1,
                              @Qualifier("cricketCoach") Coach coach2,
                              @Qualifier("swimCoach") Coach coach3){
        myCoach = coach1;
        anotherCoach = coach2;
        yetAnotherCoach = coach3;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return yetAnotherCoach.getDailyWorkout();
    }

    @GetMapping("/check")
    public String check(){
        return String.format("Comparing beans: myCoach == anotherCoach: %b", myCoach==anotherCoach);
    }
}
