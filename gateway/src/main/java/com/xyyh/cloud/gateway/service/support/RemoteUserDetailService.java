package com.xyyh.cloud.gateway.service.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.xyyh.cloud.gateway.service.UserService;
import com.xyyh.web.common.uap.dto.UserDetailsDto;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class RemoteUserDetailService implements UserService {

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDetailsDto userDto = restTemplate.getForObject("http://" + "UAP" + "/user/" + username,
				UserDetailsDto.class);
		if (userDto == null) {
			throw new UsernameNotFoundException("用户" + username + "不存在");
		}
		log.debug(String.valueOf(userDto));
		return userDto;
	}

	@Override
	public boolean passwordCheck(UserDetails user, String password) {
		return restTemplate.getForObject("http://" + "UAP" + "/user/" + user.getUsername() + "/" + password,
				Boolean.class);
	}

}
