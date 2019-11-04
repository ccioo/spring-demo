package com.taike.order.service;

import com.netflix.ribbon.proxy.annotation.Hystrix;
import com.taike.order.iservice.IOrderPayService;
import com.taike.order.vo.AlipayVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class IOrderPayServiceController implements IOrderPayService {

    @Value("${server.port}")
    private String port;

    @Override
    public String weixinpay() {
        return "微信支付成功: " + port;
    }

    @Override
    public String alipay(AlipayVO alipayVO) {
        return "支付宝支付成功：" + port;
    }


}
