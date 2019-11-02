package com.taike.ordercomsumer.controller;

import com.taike.order.service.OrderPayService1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderComsumerController {

    @Autowired
    OrderPayService1 orderPayService1;

    @RequestMapping(value = "/pay1")
    public String cumsumer() {
        return orderPayService1.pay();
    }
}
