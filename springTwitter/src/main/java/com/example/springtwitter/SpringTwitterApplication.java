package com.example.springtwitter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringTwitterApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringTwitterApplication.class, args);
    }

}
