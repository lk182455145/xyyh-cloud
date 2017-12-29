package com.xyyh.cloud.bus.cofig;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Aqueue {

	@Bean
	public Queue queue() {
		return new Queue("good");
	}

}
