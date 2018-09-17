package com.lzc.rabbitmq.message;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class MQSend {
    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send() {
        amqpTemplate.convertAndSend("myQueue","now " + new Date());
    }

    public void sendOrder1() {
        amqpTemplate.convertAndSend("myOrder","computer","now " + new Date());
    }

    public void sendOrder2() {
        amqpTemplate.convertAndSend("myOrder","fruit","now " + new Date());
    }
}
