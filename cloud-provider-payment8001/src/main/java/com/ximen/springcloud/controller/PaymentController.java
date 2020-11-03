package com.ximen.springcloud.controller;

import com.ximen.common.common.Result;
import com.ximen.common.entities.Payment;
import com.ximen.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("payment")
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private DiscoveryClient discoveryClient;

    @PostMapping("insert")
    public Result insert(Payment payment) {
        this.paymentService.insert(payment);
        return new Result(200,"添加成功");
    }

    @GetMapping("get/{id}")
    public Result findById(@PathVariable("id") Long id) {
        Payment payment = this.paymentService.findById(id);
        log.info("port: 8001，Result: {}",payment);
        Map map = new LinkedHashMap();
        map.put("payment",payment);
        map.put("port",8001);
        return new Result(200,"操作成功",map);
    }

    /**
     * 测试Feign调用超时
     * @return
     * @throws InterruptedException
     */
    @GetMapping("timeout")
    public Integer timeout() throws InterruptedException {
        Thread.sleep(3000);
        return 8001;
    }

    @GetMapping("discovery")
    public Object discovery(){
        List<String> services = this.discoveryClient.getServices();
        services.forEach(System.out::println);
        List<ServiceInstance> instances = this.discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        instances.forEach(instance -> {
            System.out.println("instanceId: " + instance.getServiceId());
            System.out.println("serviceId: " + instance.getServiceId());
            System.out.println("port: " + instance.getPort());
        });
        return discoveryClient;
    }
}
