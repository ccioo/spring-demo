package com.taike;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication(scanBasePackages = "com.taike.**")
public class MarketComsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MarketComsumerApplication.class, args);
    }
}
