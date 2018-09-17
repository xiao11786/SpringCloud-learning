package com.lzc.rabbitmq;

import com.lzc.rabbitmq.message.MQSend;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitmqApplicationTests {

    @Autowired
    private MQSend mqSend;

    @Test
    public void contextLoads() {
        mqSend.sendOrder2();
    }

}
