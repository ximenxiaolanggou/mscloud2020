package com.ximen.springcloud.service;


import com.ximen.common.common.Result;
import com.ximen.common.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(value = "nacos-payment-provider",fallback = PaymentFallbackService.class)
public interface PaymentService
{
    @GetMapping(value = "/paymentSQL/{id}")
    public Result<Payment> paymentSQL(@PathVariable("id") Long id);
}
