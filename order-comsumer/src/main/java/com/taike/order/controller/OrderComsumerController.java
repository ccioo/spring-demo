package com.taike.order.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
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

    Integer count = 0;

    @HystrixCommand(fallbackMethod = "defaultError", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",
                    value = "3000")
    })

    @RequestMapping(value = "/alipay")
    public String alipay(@ApiParam(name = "用户", value = "传入json格式", required = true) @RequestBody AlipayVO alipayVO) {
        if (StringUtils.isBlank(alipayVO.getOrderId())) {
            throw new RuntimeException();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return orderPayService1.alipay(alipayVO);
    }


    @RequestMapping(value = "/weixinpay")
    public String weixin() {
        return orderPayService1.weixinpay();
    }

    //HystrixCommandProperties
    @HystrixCommand(fallbackMethod = "defaultError",
            commandProperties = {
                    //超时设置
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000"),
                    //设置熔断
                    @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
                    //设置滚动窗口中，断路器的最小请求数量
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
                    //断路器确定是否需要打开统计请求和错误数据的时候，具有一个时间范围即时间窗口，当断路器打开，
                    //对主逻辑进行熔断之后，hystrix会启动休眠时间窗，此时降级逻辑会称为主逻辑，当休眠时间窗到期，断路
                    //器就进入half open状态
                    //尝试释放请求到原主逻辑上，就想之前描述的，成功则断路器闭合closed，失败则继续打开open，
                    // 休眠时间窗将重新计时
                    //以下设置休眠时间窗为10000毫秒
                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),
                    //设置断路器打开的百分比条件，
                    //比如此处设置为60，在滚动窗口中发生了10次request，有7次发生了异常，超出设置值，则断路器就进入
                    //open状态，反之即closed
                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")
            }
    )
    @RequestMapping(value = "/remote")
    public String remote() {
        if (count < 20) {
            count++;
            throw new RuntimeException();
        }
        count++;
        return "success";
    }


    public String defaultError(AlipayVO alipayVO) {
        return "fall back";
    }

    public String defaultError() {
        return "fall back";
    }
}
