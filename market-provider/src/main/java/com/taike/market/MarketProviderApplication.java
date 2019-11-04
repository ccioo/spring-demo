package com.taike.market;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = "com.taike.**")
public class MarketProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(MarketProviderApplication.class, args);
    }
}
