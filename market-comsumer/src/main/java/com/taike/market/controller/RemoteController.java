package com.taike.market.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RemoteController {

    @GetMapping(value = "call/order-provider")
    public String callOrderServer() {
        return "success";
    }
}
