package com.jacek.springboot.demo.springboot_demo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CricketCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes!!!";
    }

    @PostConstruct
    public void startupStuff(){
        System.out.println("Post construct");
    }

    // PreDestroy won't work with scope prototype
    @PreDestroy
    public void cleanupStuff(){
        System.out.println("Pre Destroy");
    }
}
