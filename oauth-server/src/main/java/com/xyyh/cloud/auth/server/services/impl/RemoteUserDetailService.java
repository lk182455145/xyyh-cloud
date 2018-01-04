package com.xyyh.cloud.auth.server.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.xyyh.cloud.auth.server.clients.UserClient;
import com.xyyh.cloud.auth.server.services.UserService;
import com.xyyh.web.common.uap.dto.UserDetailsDto;

@Service
public class RemoteUserDetailService implements UserService {

	@Autowired
	private UserClient userClient;

	@Override
	public UserDetailsDto loadUserByUsername(String username) throws UsernameNotFoundException {
		return userClient.loadUserByUsername(username);
	}

	@Override
	public boolean passwordCheck(String username, String password) {
		return userClient.passwordCheck(username, password);
	}

}
