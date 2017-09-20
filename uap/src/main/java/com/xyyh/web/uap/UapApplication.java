package com.xyyh.web.uap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import reactor.spring.context.config.EnableReactor;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableReactor
@EnableSwagger2
@SpringBootApplication
//@EnableDiscoveryClient
@EnableCaching
public class UapApplication {
	public static void main(String[] args) {
		SpringApplication.run(UapApplication.class);
	}
}
