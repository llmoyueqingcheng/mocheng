package com.mocheng.demo.controller;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {
	
	/**
     * 使用@JmsListener注解来监听指定的某个队列内的消息,是否有新增,有的话则取出队列内消息
     * 进行处理
     **/
    @JmsListener(destination = "mocheng.queue")
    public void removeMessage(String msg) {
    	System.out.println("消费者：来源于生产者的消息："+msg);
    }
    

}
