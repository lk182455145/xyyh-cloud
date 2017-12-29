package com.xyyh.cloud.bus.controller;

import org.springframework.amqp.core.AmqpTemplate;
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
		template.convertAndSend("good", "good");
		return "success";
	}
}
