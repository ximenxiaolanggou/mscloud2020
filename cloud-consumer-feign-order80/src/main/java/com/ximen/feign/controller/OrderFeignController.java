package com.ximen.feign.controller;

import com.ximen.common.common.Result;
import com.ximen.feign.service.PaymentFeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author zhishun.cai
 * @date 2020/10/19 15:01
 * @note
 */

@RestController
public class OrderFeignController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping(value = "/consumer/payment/get/{id}")
    public Result getPaymentById(@PathVariable("id") Long id){
        return paymentFeignService.getPaymentById(id);
    }
    @GetMapping(value = "/consumer/timeout")
    public Integer timeout() throws InterruptedException {
        return paymentFeignService.timeout();
    }
}
