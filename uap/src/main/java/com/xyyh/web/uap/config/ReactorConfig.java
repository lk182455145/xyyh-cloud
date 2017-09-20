package com.xyyh.web.uap.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import reactor.Environment;
import reactor.bus.EventBus;

@Configuration
public class ReactorConfig {


	/*@Bean
	public EventBus eventBus(Environment env ) {
		return EventBus.create(env, Environment.THREAD_POOL);
	}*/
}
