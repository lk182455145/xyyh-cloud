package com.xyyh.cloud.auth.server.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	/**
	 * 配置登录页面
	 * 
	 * 如果用户要访问oauth相关的接口，这些接口必须被保护起来
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.authorizeRequests().antMatchers("/login").permitAll()
				.antMatchers("/oauth/**").authenticated()
				.anyRequest().authenticated().and()
				.formLogin();
		// 注意，如果我们的资源服务器和授权服务器在同一个应用中，必须确保资源服务器保护的链接和formlogin保护的链接分开。
		// 如果不分开的话，会导致所有的请求优先通过formlogin,这样，所有的请求都会进入登录入口点，而不会进入@EnableResourceServer的配置
		http.requestMatchers().antMatchers("/login", "/oauth/**");
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN");
	}
}
