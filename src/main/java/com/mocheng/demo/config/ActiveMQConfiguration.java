package com.mocheng.demo.config;

import javax.jms.Queue;
import javax.jms.Topic;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;

@Configuration
@EnableJms
public class ActiveMQConfiguration {

	/**
	* 定义点对点队列，实现多队列
	* @return
	*/
	@Bean("catMapping.queue")
	public Queue catMappingQueue() {
	return new ActiveMQQueue("catMapping.queue");
	}
	
	@Bean("mapping.queue")
	public Queue mappingQueue() {
		return new ActiveMQQueue("mapping.queue");
	}
	
	@Bean("part.queue")
	public Queue partQueue() {
		return new ActiveMQQueue("part.queue");
	}
	
	
}
