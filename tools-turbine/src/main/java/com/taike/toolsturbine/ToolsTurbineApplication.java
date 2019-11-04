package com.taike.toolsturbine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

@EnableTurbine
@EnableDiscoveryClient
@SpringBootApplication
@EnableHystrixDashboard
public class ToolsTurbineApplication {
    public static void main(String[] args) {
        SpringApplication.run(ToolsTurbineApplication.class, args);
    }

}
