package com.ximen.order.controller;

import com.ximen.common.common.Result;
import com.ximen.common.entities.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@RestController
public class OrderController {

//    public static final String PAYMENT_URL = "http://localhost:8001";
    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/get/{id}")
    public Result<Payment> getPayment(@PathVariable("id") Long id){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,Result.class);
    }

    @GetMapping("/consumer/payment/getForEntity/{id}")
    public Result<Payment> getForEntity(@PathVariable("id") Long id){
        ResponseEntity<Result> entity = restTemplate.getForEntity(PAYMENT_URL + "/payment/get/" + id, Result.class);
        System.out.println("code" + entity.getStatusCodeValue());
        HttpHeaders headers = entity.getHeaders();
        for (Map.Entry<String, List<String>> stringListEntry : headers.entrySet()) {
            System.out.println("key: " + stringListEntry.getKey());
            System.out.println("value: " + stringListEntry.getValue());
        }
        return entity.getBody();
    }
}
