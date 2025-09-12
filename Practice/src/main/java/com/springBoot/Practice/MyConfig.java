package com.springBoot.Practice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.*;


@Configuration
public class MyConfig {
    @Bean
    public CommandLineRunner myline(){
        return args -> System.out.println("🔥 CommandLineRunner Loaded via Kotlin DSL Project!");
    }
    @Autowired
    calculatorTest ct;

    @Bean
    public CommandLineRunner sumPrint(){
        return args -> System.out.println("The sum of 1,2,3,4,5 is = "+ct.sum(1,2,3,4,5));
    }
}



