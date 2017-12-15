package com.xyyh.cache;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.redis.cache.RedisCacheManager;

@SpringBootApplication
@EnableCaching
public class CacheApplication extends SpringBootServletInitializer {

	@Autowired
	private CacheManager cacheManager;

	public static void main(String[] args) throws Exception {
		SpringApplication.run(CacheApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(CacheApplication.class);
	}

	@PostConstruct
	public void set() {
		RedisCacheManager m = (RedisCacheManager) cacheManager;
		m.setDefaultExpiration(10);
	}
}
