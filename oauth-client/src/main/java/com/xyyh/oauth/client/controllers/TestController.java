package com.xyyh.oauth.client.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class TestController {

	@Autowired
	@Lazy
	private OAuth2RestTemplate template;

	@GetMapping
	public String test() {
		ResponseEntity<Object> response = template.getForEntity("http://localhost:8080/user", Object.class);
		ResponseEntity<Object> response2 = template.getForEntity("http://localhost:8081/test", Object.class);

		System.out.println(response);
		return "test=" + response.getBody().toString() + "\r\n  test2=" + response2.getBody();
	}

}
