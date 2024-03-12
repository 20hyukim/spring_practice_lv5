package com.sparta.spartagoods;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SpartagoodsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpartagoodsApplication.class, args);
    }

}
