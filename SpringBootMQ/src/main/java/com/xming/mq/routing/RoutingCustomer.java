package com.xming.mq.routing;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RoutingCustomer {

    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue, // 创建临时队列
                    exchange = @Exchange(value = "directs",type = "direct"), // 自定义交换机名称和类型
                    key = {"info","error","warn"}
            )
    })
    public void receive1(String message){
        System.err.println(" route1 message = "+message);
    }


    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue, // 创建临时队列
                    exchange = @Exchange(value = "directs",type = "direct"), // 自定义交换机名称和类型
                    key = {"info","error","warn"}
            )
    })
    public void receive2(String message){
        System.err.println(" route2 message = "+message);
    }

}
