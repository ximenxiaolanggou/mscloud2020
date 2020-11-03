package com.ximen.springcloud.service.impl;

import com.ximen.common.entities.Payment;
import com.ximen.springcloud.mapper.PaymentMapper;
import com.ximen.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentMapper paymentDao;

    @Override
    public void insert(Payment payment) {
        this.paymentDao.insert(payment);
    }

    @Override
    public Payment findById(Long id) {
        return this.paymentDao.selectByPrimaryKey(id);
    }
}
