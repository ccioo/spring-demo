package com.taike.order.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.taike.order.iservice.IOrderPayService;
import com.taike.order.vo.AlipayVO;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderComsumerController {

    @Autowired
    IOrderPayService orderPayService1;

    @HystrixCommand(fallbackMethod = "defaultError")
    @RequestMapping(value = "/alipay")
    public String alipay(@ApiParam(name = "用户", value = "传入json格式", required = true) @RequestBody AlipayVO alipayVO) {
        if(StringUtils.isBlank(alipayVO.getOrderId())){
            throw new RuntimeException();
        }
        return orderPayService1.alipay(alipayVO);
    }


    @RequestMapping(value = "/weixinpay")
    public String weixin() {
        return orderPayService1.weixinpay();
    }


    public String defaultError(AlipayVO alipayVO) {
        return "fall back";
    }
}
