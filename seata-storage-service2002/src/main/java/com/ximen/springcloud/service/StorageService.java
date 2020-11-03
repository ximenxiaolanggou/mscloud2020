package com.ximen.springcloud.service;

/**
 * @author zhishun.cai
 * @date 2020/10/29 10:19
 * @note
 */

public interface StorageService {

    // 扣减库存
    void decrease(Long productId, Integer count);
}
