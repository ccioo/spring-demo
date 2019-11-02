package com.taike.order.service.iservice;

import com.taike.order.service.vo.AlipayVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@FeignClient("order-provider")
public interface IOrderPayService {


    @RequestMapping(value = "alipay2", method = RequestMethod.POST)
    String alipay(@RequestBody AlipayVO alipayVO);


    @RequestMapping(value = "weixinpay2", method = RequestMethod.GET)
    String weixinpay();

}
