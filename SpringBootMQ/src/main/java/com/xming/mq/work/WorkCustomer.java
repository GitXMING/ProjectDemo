package com.xming.mq.work;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class WorkCustomer {

    // 消费者1
    @RabbitListener(queuesToDeclare = @Queue("work"))
    public void receive1(String message){
        System.err.println(" message 1 = " + message);
    }

    // 消费者2
    @RabbitListener(queuesToDeclare = @Queue("work"))
    public void receive2(String message){
        System.err.println(" message 2 = " + message);
    }


}
