package com.xyyh.cloud.bus;

import javax.annotation.PostConstruct;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BusApplication {

//	@Autowired
//	private AmqpTemplate template;

	public static void main(String[] args) throws Exception {
		SpringApplication.run(BusApplication.class, args);
	}

	@PostConstruct
	public void dsiplay() {
//		System.out.println(template);
	}
}
