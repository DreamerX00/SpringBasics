package com.springBoot.Practice.StartersPractice;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.*;


@Configuration
@ComponentScan(basePackages = "com.springBoot.Practice")
@EnableAutoConfiguration
public class day1 {
    @Bean
    public CommandLineRunner runner(){
        return args -> System.out.println("Testing from day1 file");
    }
    @Bean
    public CommandLineRunner helloPrint(){

        return args -> System.out.println(5+5+" is = Ten");
    }
}
