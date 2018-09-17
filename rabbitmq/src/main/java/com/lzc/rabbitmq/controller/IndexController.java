package com.lzc.rabbitmq.controller;

import com.lzc.rabbitmq.message.MQSend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class IndexController {
    @Autowired
    private MQSend mqSend;

    @GetMapping("/send")
    public String send() {
        mqSend.send();
        return "0";
    }

    @GetMapping("/computer")
    public String computer() {
        mqSend.sendOrder1();
        return "1";
    }

    @GetMapping("/fruit")
    public String fruit() {
        mqSend.sendOrder2();
        return "2";
    }


}
