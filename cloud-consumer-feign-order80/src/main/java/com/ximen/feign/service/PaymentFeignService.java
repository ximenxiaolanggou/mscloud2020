package com.ximen.feign.service;

import com.ximen.common.common.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author zhishun.cai
 * @date 2020/10/19 14:58
 * @note
 */

@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {

    @GetMapping(value = "/payment/get/{id}")
    public Result getPaymentById(@PathVariable("id") Long id);

    @GetMapping("/payment/timeout")
    public Integer timeout() throws InterruptedException;
}

