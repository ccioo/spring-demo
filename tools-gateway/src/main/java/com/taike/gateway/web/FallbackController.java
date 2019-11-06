package com.taike.gateway.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {


    @GetMapping("/fallback")
    public String fallback() {
        return "Spring Cloud Gateway Fallback";
    }

}
