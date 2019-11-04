package com.taike.order.config;

import com.netflix.client.config.IClientConfig;
import com.netflix.discovery.converters.Auto;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@AvoidTag
@Configuration
public class RibbonSpecialConfiguration {

    @Autowired
    private IClientConfig iClientConfig;

    @Bean
    public IRule ribbinRules(IClientConfig iClientConfig) {
        return new RandomRule();
    }
}
