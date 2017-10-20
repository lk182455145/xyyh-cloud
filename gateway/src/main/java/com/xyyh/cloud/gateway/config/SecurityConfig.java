package com.xyyh.cloud.gateway.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.Http401AuthenticationEntryPoint;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.Http403ForbiddenEntryPoint;

import com.xyyh.cloud.gateway.security.RemoteUserDetailsAuthenticationProvider;
import com.xyyh.cloud.gateway.service.UserService;
import com.xyyh.cloud.security.Http401Entrypoint;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserService userDetailsService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/**").hasAnyRole("ADMIN", "USER").and().formLogin().and()
				.httpBasic().disable();
		http.csrf().disable();
		http.exceptionHandling().authenticationEntryPoint(new Http401Entrypoint());
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}

	private AuthenticationProvider authenticationProvider() {
		RemoteUserDetailsAuthenticationProvider ruda = new RemoteUserDetailsAuthenticationProvider();
		ruda.setUserService(userDetailsService);
		return ruda;
	}
}
