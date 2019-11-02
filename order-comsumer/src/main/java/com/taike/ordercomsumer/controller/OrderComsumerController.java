package com.taike.ordercomsumer.controller;

import com.taike.order.service.iservice.IOrderPayService;
import com.taike.order.service.vo.AlipayVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderComsumerController {

    @Autowired
    IOrderPayService orderPayService1;

    @RequestMapping(value = "/alipay")
    public String alipay(AlipayVO alipayVO) {
        return orderPayService1.alipay(alipayVO);
    }

    @RequestMapping(value = "/weixinpay")
    public String weixin() {
        return orderPayService1.weixinpay();
    }
}
