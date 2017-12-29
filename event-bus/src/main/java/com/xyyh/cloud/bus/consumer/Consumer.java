package com.xyyh.cloud.bus.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

	@RabbitHandler
	@RabbitListener(queues = "good")
	public void handler(String message) {
		System.out.println(message);
	}
}
