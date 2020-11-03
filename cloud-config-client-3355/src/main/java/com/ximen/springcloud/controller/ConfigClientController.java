package com.ximen.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhishun.cai
 * @date 2020/10/21 15:17
 * @note
 */

@RestController
@RefreshScope
public class ConfigClientController {

    @Value("${type}")
    private String type;

    @GetMapping("/configInfo")
    public String getConfigInfo(){
        return type;
    }
}

