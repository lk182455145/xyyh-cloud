package com.xyyh.cloud.auth.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class AuthServerApplication {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(AuthServerApplication.class, args);
	}
}
