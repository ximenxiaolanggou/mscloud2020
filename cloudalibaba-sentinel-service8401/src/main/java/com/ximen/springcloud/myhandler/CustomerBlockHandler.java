package com.ximen.springcloud.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.ximen.common.common.Result;

/**
 * @author zhishun.cai
 * @date 2020/10/27 16:44
 * @note
 */

public class CustomerBlockHandler {
    public static Result handlerException1(BlockException exception) {
        return new Result(444, exception.getClass().getCanonicalName() + "\t 服务不可用 --- 1");
    }

    public static Result handlerException2(BlockException exception) {
        return new Result(444, exception.getClass().getCanonicalName() + "\t 服务不可用 --- 2");
    }
}
