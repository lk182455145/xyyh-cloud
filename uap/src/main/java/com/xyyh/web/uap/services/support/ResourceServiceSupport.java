package com.xyyh.web.uap.services.support;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xyyh.web.uap.entity.Resource;
import com.xyyh.web.uap.services.ResourceService;

import lombok.extern.slf4j.Slf4j;
import reactor.bus.Event;
import reactor.bus.EventBus;
import reactor.spring.context.annotation.Consumer;
import reactor.spring.context.annotation.Selector;

@Service
@Consumer
@Slf4j
public class ResourceServiceSupport implements ResourceService {

	
	@Autowired
	private EventBus eventBus;

	@Override
	public List<Resource> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Selector(value = "test")
	public void test(Event<String> event) {
		log.info(event.getData());
		System.out.println(event.getData());
	}
}
