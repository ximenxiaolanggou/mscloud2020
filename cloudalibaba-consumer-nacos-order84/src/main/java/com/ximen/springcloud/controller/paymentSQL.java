package com.ximen.springcloud.controller;

import com.ximen.common.common.Result;
import com.ximen.common.entities.Payment;
import com.ximen.springcloud.service.PaymentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author zhishun.cai
 * @date 2020/10/27 19:04
 * @note
 */

@RestController
public class paymentSQL {
    @Resource
    private PaymentService paymentService;

    @GetMapping(value = "/consumer/paymentSQL/{id}")
    public Result<Payment> paymentSQL(@PathVariable("id") Long id) {
        return paymentService.paymentSQL(id);
    }
}
