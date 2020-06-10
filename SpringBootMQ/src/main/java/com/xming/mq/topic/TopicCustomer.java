package com.xming.mq.topic;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class TopicCustomer {

    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue, // 创建临时队列
                    exchange = @Exchange(type = "topic",value = "topics"), // 自定义交换机名称和类型
                    key = {"xming.save","xming.*"}
            )
    })
    public void receive1(String message){
        System.err.println(" topic1 message = "+message);
    }


    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue, // 创建临时队列
                    exchange = @Exchange(type = "topic",value = "topics"), // 自定义交换机名称和类型
                    key = {"order.save","xming.*"}
            )
    })
    public void receive2(String message){
        System.err.println(" topic2 message = "+message);
    }

}
