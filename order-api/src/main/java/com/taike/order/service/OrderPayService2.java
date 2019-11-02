package com.taike.order.service;

import org.springframework.cloud.openfeign.FeignClient;


@FeignClient("order-provider")
public interface OrderPayService2 {

    String pay();

}
