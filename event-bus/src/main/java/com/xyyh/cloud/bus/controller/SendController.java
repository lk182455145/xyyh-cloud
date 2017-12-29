package com.xyyh.cloud.bus.controller;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 定义一个生产者
 * 
 * @author LiDong
 *
 */
@RestController
@RequestMapping("/test")
public class SendController {
	@Autowired
	private AmqpTemplate template;

	@GetMapping
	public String testSend() {
		// 使用AmqpTemplate发送消息
		template.convertAndSend("good", "good");
		return "success";
	}
}
