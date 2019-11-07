package com.taike.order.iservice;

import com.taike.order.vo.AlipayVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@FeignClient("order-provider")
public interface IOrderPayService {


    @RequestMapping(value = "/alipays", method = RequestMethod.POST)
    String alipay(@RequestBody AlipayVO alipayVO);


    @RequestMapping(value = "/weixinpays", method = RequestMethod.GET)
    String weixinpay();

}
