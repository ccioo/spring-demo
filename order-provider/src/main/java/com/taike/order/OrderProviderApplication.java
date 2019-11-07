package com.taike.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableHystrix
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
@RestController
public class OrderProviderApplication {

    public boolean cache;


    public static void main(String[] args) {
        SpringApplication.run(OrderProviderApplication.class, args);
    }

    @GetMapping(value = "fresh")
    public boolean test() {
        return cache;
    }

    @GetMapping(value = "/jd")
    public boolean dd() {
        return true;
    }

}
