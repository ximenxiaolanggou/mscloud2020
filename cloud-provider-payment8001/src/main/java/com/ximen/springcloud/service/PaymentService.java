package com.ximen.springcloud.service;


import com.ximen.common.entities.Payment;

public interface PaymentService {
    
    void insert(Payment payment);

    Payment findById(Long id);
}
