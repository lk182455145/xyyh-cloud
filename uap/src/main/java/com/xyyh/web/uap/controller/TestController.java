package com.xyyh.web.uap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import reactor.bus.Event;
import reactor.bus.EventBus;

@RestController
@RequestMapping("test")
public class TestController {

	@Autowired
	private EventBus eventBus;

	@RequestMapping(method=RequestMethod.GET)
	public String test() {
		System.out.println("dddd");
		eventBus.notify("test", Event.wrap("test"));
		return "test";
	}
}
