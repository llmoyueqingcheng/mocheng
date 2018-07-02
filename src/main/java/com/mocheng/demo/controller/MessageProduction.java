package com.mocheng.demo.controller;

import javax.jms.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

//注册为一个bean
@Component
//开启定时器
@EnableScheduling
public class MessageProduction {
	
	@Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;//使用JmsMessagingTemplate将消息放入队列

	//指定注入的队列
	@Autowired
	@Qualifier("mapping.queue")
	private Queue queue;


    @Scheduled(fixedDelay = 3000)//每3s执行1次,将消息放入队列内
    public void send() {
        this.jmsMessagingTemplate.convertAndSend(this.queue, "生产者辛苦生产的点对点消息成果");
        System.out.println("生产者：辛苦生产的点对点消息成果");
    }

}
