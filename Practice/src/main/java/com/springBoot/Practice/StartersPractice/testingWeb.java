package com.springBoot.Practice.StartersPractice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testingWeb {
    @GetMapping("/TestingHello")
    public String hello(){
        return "Hello from Spring Boot Application 🕺";
    }
}
