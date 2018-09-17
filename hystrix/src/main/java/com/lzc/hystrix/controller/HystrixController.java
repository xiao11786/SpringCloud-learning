package com.lzc.hystrix.controller;

import com.lzc.hystrix.client.ProductClient;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by lzc
 * 2018/9/16 23:58
 */
@RestController
@DefaultProperties(defaultFallback = "defaultFallback")
public class HystrixController {

    @Autowired
    private ProductClient productClient;

//    @HystrixCommand(fallbackMethod = "fallback")
//    @GetMapping("/hystrixTest")
//    public Object hystrixTest() {
//        RestTemplate restTemplate = new RestTemplate();
//        return restTemplate.getForObject("http://localhost:8083/msg",String.class);
//    }
//
//    private Object fallback() {
//        return "太拥挤了，请稍后再试！";
//    }

    // 超时配置
//    @HystrixCommand(commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
//    })
//    @HystrixCommand(commandProperties = {
//            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
//            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
//            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),
//            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")
//    })
    @GetMapping("/hystrixTest")
    @HystrixCommand
    public Object hystrixTest() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("http://localhost:8083/msg",String.class);
    }

    private Object defaultFallback() {
        return "【默认】太拥挤了，请稍后再试！";
    }

    @GetMapping("/msg")
    public String msg() {
        return productClient.msg();
    }
}
