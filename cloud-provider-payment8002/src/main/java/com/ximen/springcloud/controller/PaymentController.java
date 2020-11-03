package com.ximen.springcloud.controller;

import com.ximen.common.common.Result;
import com.ximen.common.entities.Payment;
import com.ximen.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("payment")
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("insert")
    public Result insert(Payment payment) {
        this.paymentService.insert(payment);
        return new Result(200,"添加成功");
    }

    @GetMapping("get/{id}")
    public Result findById(@PathVariable("id") Long id) {
        Payment payment = this.paymentService.findById(id);
        Map map = new LinkedHashMap();
        map.put("payment",payment);
        map.put("port",8002);
        return new Result(200,"操作成功",map);
    }
}
