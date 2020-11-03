package com.ximen.springcloud.mapper;

import com.ximen.common.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PaymentMapper{
    void insert(@Param("payment") Payment payment);

    Payment selectByPrimaryKey(@Param("id") Long id);
}
