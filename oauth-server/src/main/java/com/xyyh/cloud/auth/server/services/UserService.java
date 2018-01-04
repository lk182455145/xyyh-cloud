package com.xyyh.cloud.auth.server.services;

import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * 远程获取用户的服务调用
 *
 * @author LiDong
 *
 */

public interface UserService extends UserDetailsService {
	/**
	 * 校验用户的密码
	 * 
	 * @param user
	 * @param password
	 * @return
	 */
	public boolean passwordCheck(String username, String password);

}
