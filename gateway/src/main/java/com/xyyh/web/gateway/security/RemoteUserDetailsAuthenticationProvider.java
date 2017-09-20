package com.xyyh.web.gateway.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.xyyh.web.gateway.service.UserService;

@Component("authenticationProvider")
public class RemoteUserDetailsAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

	@Autowired
	private UserService userService;

	@Override
	protected void additionalAuthenticationChecks(UserDetails userDetails,
			UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
		try {
			if (!userService.passwordCheck(userDetails, String.valueOf(authentication.getCredentials()))) {
				throw new BadCredentialsException("用户密码输入错误");
			}
		} catch (Exception e) {
			throw new BadCredentialsException("用户密码校验时出现异常", e);
		}
	}

	@Override
	protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication)
			throws AuthenticationException {
		return userService.loadUserByUsername(username);
	}

}
