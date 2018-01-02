package com.xyyh.cloud.auth.server.controllers;

import java.security.Principal;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class TestController {

	@GetMapping("test")
	public Principal test(@AuthenticationPrincipal Principal userdetails) {
		return userdetails;
	}
}
