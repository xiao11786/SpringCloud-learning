package com.lzc.rabbitmq.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 接收MQ消息
 */
@Component
@Slf4j
public class MQReceiver {

//    @RabbitListener(queues = "myQueue")
//    public void process(String message) {
//        System.out.println("*************MqReceiver收到消息:" + message + "*************");
//    }

    // 可以自动创建队列
//    @RabbitListener(queuesToDeclare = @Queue("myQueue"))
//    public void process(String message) {
//        System.out.println("*************MqReceiver收到消息:" + message + "*************");
//    }

    // 自动创建 Exchange和Queue绑定
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue("myQueue"),
            exchange = @Exchange("myExchange")
    ))
    public void process(String message) {
        System.out.println("*************MqReceiver收到消息:" + message + "*************");
    }

    /**
     * 电脑供应商
     * @param message
     */
    @RabbitListener(bindings = @QueueBinding(
            exchange = @Exchange("myOrder"),
            key = {"computer"},
            value = @Queue("computerOrder")
    ))
    public void processComputer(String message) {
        System.out.println("*************computer MqReceiver收到消息:" + message + "*************");
    }

    /**
     * 水果供应商
     * @param message
     */
    @RabbitListener(bindings = @QueueBinding(
            exchange = @Exchange("myOrder"),
            key = {"fruit"},
            value = @Queue("fruitOrder")
    ))
    public void processFruit(String message) {
        System.out.println("*************Fruit MqReceiver收到消息:" + message + "*************");
    }
}
