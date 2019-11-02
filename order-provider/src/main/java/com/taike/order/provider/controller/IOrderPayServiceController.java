package com.taike.order.provider.controller;

import com.taike.order.service.iservice.IOrderPayService;
import com.taike.order.service.vo.AlipayVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class IOrderPayServiceController implements IOrderPayService {


    @Override
    public String weixinpay() {
        return "微信支付成功";
    }

    @Override
    public String alipay(AlipayVO alipayVO) {
        return "订单：" +alipayVO.getOrderId() + " 支付宝支付成功";
    }


}
