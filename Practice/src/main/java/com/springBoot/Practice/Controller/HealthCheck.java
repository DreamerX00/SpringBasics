package com.springBoot.Practice.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheck {
    @GetMapping("/health-check")
    public String healthCheck(){
        return "Application is running fine !!";
    }
}
