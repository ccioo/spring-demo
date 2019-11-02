package com.taike.order.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;


@FeignClient("order-provider")
public interface OrderPayService1 {

    @RequestMapping(value = "/pay")
    String pay();

}
