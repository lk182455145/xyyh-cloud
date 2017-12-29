package com.xyyh.cloud.bus.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

	/**
	 * 定义一个消费者
	 * @param message
	 */
	@RabbitHandler
	@RabbitListener(queues = "good")
	public void handler(String message) {
		System.out.println("recive message from " + message);
	}
}
