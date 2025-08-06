package com.jacek.springboot.demo.springboot_demo.config;

import com.jacek.springboot.demo.springboot_demo.common.Coach;
import com.jacek.springboot.demo.springboot_demo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    @Bean
    public Coach swimCoach(){
        return new SwimCoach();
    }
}
