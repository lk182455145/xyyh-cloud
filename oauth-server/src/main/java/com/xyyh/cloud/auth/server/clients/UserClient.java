package com.xyyh.cloud.auth.server.clients;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.xyyh.web.common.uap.dto.UserDetailsDto;

@FeignClient("UAP/user")
public interface UserClient {

	@RequestMapping(value = "{username}", method = RequestMethod.GET)
	public UserDetailsDto loadUserByUsername(@PathVariable("username") String username);
	
	/**
	 * 校验用户的密码
	 * 
	 * @param user
	 * @param password
	 * @return
	 */
	@RequestMapping(value = "valid", method = RequestMethod.POST)
	public boolean passwordCheck(@RequestParam("username") String username, @RequestParam("password") String password);
}
