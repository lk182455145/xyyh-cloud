package com.xyyh.cloud.gateway.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xyyh.cloud.gateway.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping("user/{username}")
	public UserDetails test(@PathVariable("username") String username) {
		return userService.loadUserByUsername(username);
	}

}
