package com.xyyh.web.gateway.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

	@RequestMapping("login")
	public String login() {
		return "login";
	}

	@RequestMapping("test")
	public ModelAndView test() {
		return new ModelAndView("test");
	}

}
