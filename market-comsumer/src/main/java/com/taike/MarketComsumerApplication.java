package com.taike;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MarketComsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MarketComsumerApplication.class, args);
    }
}
