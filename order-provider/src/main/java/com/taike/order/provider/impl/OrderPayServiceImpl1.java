package com.taike.order.provider.impl;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderPayServiceImpl1 implements com.taike.order.service.OrderPayService1 {

    @Override
    public String pay() {
        return "第一种支付：成功";
    }
}
