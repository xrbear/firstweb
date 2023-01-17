package com.study.demo.rabbitmq.listener;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author ：xurong02
 * @date ：2023/1/17 10:09 上午
 */
@Component
@RabbitListener(queues = "TestDirectQueue")
public class SecondTestDirectListener {

    @RabbitHandler
    public void process(Map testMessage){
        System.out.println("第二个TestDirectListener:"+ testMessage.toString());
    }
}
