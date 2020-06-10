package com.xming.mq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = MqApplication.class)
@RunWith(SpringRunner.class)
public class MqApplicationTests {

    // 注入模板
    @Autowired
    RabbitTemplate rabbitTemplate;

    // 简单队列生产者
    @Test
    public void test(){
        rabbitTemplate.convertAndSend("hello","hello world");
    }

    // 工作队列生产者
    @Test
    public void testWork(){
        rabbitTemplate.convertAndSend("work","work模型");
    }

    // fanout广播 生产者
    @Test
    public void testFanout(){
        rabbitTemplate.convertAndSend("logs","","fanout模型");
    }

    // routing 路由模式
    @Test
    public void testRoute(){
        rabbitTemplate.convertAndSend("directs","xming","directs发送的消息");
    }


    // topic 动态路由  订阅模式
    @Test
    public void testTopic(){
        rabbitTemplate.convertAndSend("topics","order.save","xming.save 路由消息 ");
    }


}
