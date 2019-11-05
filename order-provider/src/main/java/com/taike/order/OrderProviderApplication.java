package com.taike.order;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableHystrix
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = "com.taike.**")
@NacosPropertySource(dataId = "order-provider", autoRefreshed = true)
@RestController
public class OrderProviderApplication {

    @NacosValue(value = "${useLocalCache}", autoRefreshed = true)
    public boolean cache;


    public static void main(String[] args) {
        SpringApplication.run(OrderProviderApplication.class, args);
    }

    @GetMapping(value = "fresh")
    public boolean test() {
        return cache;
    }

}
