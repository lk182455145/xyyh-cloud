package com.xyyh.cache.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("test")
@Slf4j
public class TestController {

	@Autowired
	private CacheManager cacheManager;

	@GetMapping
	// @Cacheable(cacheNames = "testCache", key = "'test'")
	public String test() {
//		log.info("cacheManager=" + cacheManager);
//		log.info("get data from method");
		return "good good study! day day up!";
	}

	@GetMapping("manager")
	public String manager() {
		return cacheManager.toString();
	}

	@GetMapping("delete")
	@CacheEvict(allEntries = true, cacheNames = "testCache")
	public String delete() {
		return "success";
	}
}
