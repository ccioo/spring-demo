package com.taike.order;

import com.taike.order.config.RibbonSpecialConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@RibbonClient(name = "order-provider",
        configuration = RibbonSpecialConfiguration.class)
//@RibbonClients(value = {
//		@RibbonClient(name = "order-provider", configuration = TestConfiguration.class),
//		@RibbonClient(name = "order-provider", configuration = TestConfiguration.class)
//})
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = "com.taike.**")
public class OrderComsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderComsumerApplication.class, args);
    }

}
