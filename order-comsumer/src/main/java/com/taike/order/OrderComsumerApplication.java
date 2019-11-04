package com.taike.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = "com.taike.**")
public class OrderComsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderComsumerApplication.class, args);
    }

}
