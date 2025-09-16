package com.springBoot.Practice.StartersPractice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class calculatorTest {
        @Bean
        public static int sum(int... num){
            int sum = 0;
            for(int item : num){
                sum+=item;
            }
            return sum;
        }
}
