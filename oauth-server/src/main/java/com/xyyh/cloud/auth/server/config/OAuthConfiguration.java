package com.xyyh.cloud.auth.server.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

/**
 * 这个类，主要做一些授权服务器的配置
 * 
 * @author LiDong
 *
 */
@Configuration
@EnableAuthorizationServer
public class OAuthConfiguration extends AuthorizationServerConfigurerAdapter {

	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
		// security.allowFormAuthenticationForClients();
		// security

	}

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		// clients.configure(builder);
		// clients.and().jdbc().clients(clientDetailsService);
		clients.inMemory()
				.withClient("client")
				.secret("test")
				.authorizedGrantTypes("authorization_code")
				.scopes("app", "cas")
				// 是否启用自动授权
				.autoApprove(false).autoApprove("cas");
		// clients.withClientDetails(clientDetailsService);

	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		super.configure(endpoints);
		endpoints.accessTokenConverter(tokenConverter());
		endpoints.tokenStore(tokenStore());
	}

	// 用jwt保存token信息
	@Bean
	public JwtTokenStore tokenStore() {
		return new JwtTokenStore(tokenConverter());
	}

	@Bean
	public JwtAccessTokenConverter tokenConverter() {
		JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
		converter.setSigningKey("good");
		return converter;
	}
}
