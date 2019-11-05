package com.taike.order;

import com.taike.order.config.AvoidTag;
import com.taike.order.config.RibbonSpecialConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

//@RibbonClients(value = {
//		@RibbonClient(name = "order-provider", configuration = TestConfiguration.class),
//		@RibbonClient(name = "order-provider", configuration = TestConfiguration.class)
//})
@EnableHystrix
@RibbonClient(name = "order-provider",
        configuration = RibbonSpecialConfiguration.class)
@EnableFeignClients
@EnableDiscoveryClient
//Spring 不要扫描被该注解标记的类
@ComponentScan(value = "com.taike.**", excludeFilters =
        {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = {AvoidTag.class})})
@SpringBootApplication

public class OrderComsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderComsumerApplication.class, args);
    }

}
