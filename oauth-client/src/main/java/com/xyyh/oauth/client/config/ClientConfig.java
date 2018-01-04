package com.xyyh.oauth.client.config;

import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.token.AccessTokenProviderChain;
import org.springframework.security.oauth2.client.token.grant.code.AuthorizationCodeAccessTokenProvider;

@EnableWebSecurity
@EnableOAuth2Sso
public class ClientConfig extends WebSecurityConfigurerAdapter {
	// @Autowired
	// private AuthorizationCodeAccessTokenProvider tokenProvider;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/login").permitAll()
				.anyRequest().authenticated();
		http.httpBasic().disable();
		http.csrf().disable();
	}

	@PostConstruct
	public void test() {
		// System.out.println(template);
	}

	/**
	 * 使用这个Template访问资源
	 * @param context
	 * @param details
	 * @return
	 */
	@Bean
	public OAuth2RestTemplate oauth2RestTemplate(OAuth2ClientContext context, OAuth2ProtectedResourceDetails details) {
		OAuth2RestTemplate template = new OAuth2RestTemplate(details, context);

		AuthorizationCodeAccessTokenProvider authCodeProvider = new AuthorizationCodeAccessTokenProvider();
		authCodeProvider.setStateMandatory(false);
		AccessTokenProviderChain provider = new AccessTokenProviderChain(
				Arrays.asList(authCodeProvider));
		template.setAccessTokenProvider(provider);
		return template;
	}

}
