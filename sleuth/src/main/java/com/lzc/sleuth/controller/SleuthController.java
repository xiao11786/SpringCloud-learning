package com.lzc.sleuth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by lzc
 * 2018/9/17 16:44
 */
@RestController
public class SleuthController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/sleuth")
    public String sleuth() {
        String response = restTemplate.getForObject("http://PRODUCT/msg", String.class);
        return response;
    }
}
