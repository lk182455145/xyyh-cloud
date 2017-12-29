package com.xyyh.cloud.bus.controller;

import java.util.UUID;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class SendController {
	@Autowired
	private AmqpTemplate template;

	@GetMapping
	public String testSend() {
		// template.convertAndSend("good", "list1");
		// CorrelationData correlationId = new
		// CorrelationData(UUID.randomUUID().toString());
		template.convertAndSend("good", "good");
		return "success";
	}
}
