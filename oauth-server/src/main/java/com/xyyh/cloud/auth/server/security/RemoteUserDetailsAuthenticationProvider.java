package com.xyyh.cloud.auth.server.security;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;

import com.xyyh.cloud.auth.server.services.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RemoteUserDetailsAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Override
	protected void additionalAuthenticationChecks(UserDetails userDetails,
			UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
		try {
			if (!userService.passwordCheck(userDetails.getUsername(),
					String.valueOf(authentication.getCredentials()))) {
				throw new BadCredentialsException("用户密码输入错误");
			}
		} catch (Exception e) {
			log.error("校验用户密码时出错", e);
			throw new BadCredentialsException("用户密码校验时出现异常", e);
		}
	}

	@Override
	protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication)
			throws AuthenticationException {
		return userService.loadUserByUsername(username);
	}

}
