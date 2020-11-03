package com.ximen.springcloud.service;



import com.ximen.common.common.Result;
import com.ximen.common.entities.Payment;
import org.springframework.stereotype.Component;


@Component
public class PaymentFallbackService implements PaymentService
{
    @Override
    public Result<Payment> paymentSQL(Long id)
    {
        return new Result<>(44444,"服务降级返回,---PaymentFallbackService",new Payment(id,"errorSerial"));
    }
}
