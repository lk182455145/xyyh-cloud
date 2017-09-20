package com.xyyh.web.uap.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.xyyh.web.common.uap.dto.UserDto;
import com.xyyh.web.uap.entity.User;

public interface UserService {
	/**
	 * 根据用户ID获取用户信息
	 * 
	 * @param id
	 * @return
	 */
	public User loadById(long id);

	/**
	 * 保存用户信息，包括密码信息
	 * 
	 * @param user
	 * @return
	 */
	public User save(UserDto user);

	/**
	 * 更新用户信息，但不会更新密码信息
	 * 
	 * @param user
	 * @return
	 */
	public User update(UserDto user);

	/**
	 * 修改已知用户的密码
	 * 
	 * @param userId
	 * @param password
	 */
	public void changePasswordById(long userId, String password);

	/**
	 * 根据用户名查找用户
	 * 
	 * @param userName
	 * @return
	 */
	public User loadByUserName(String userName);

	/**
	 * 根据用户名模糊查询用户列表
	 * 
	 * @param username
	 *            模糊用户名
	 * @param pageRequest
	 *            分页请求
	 * @return
	 */
	public Page<User> findByUsername(String username, Pageable pageRequest);

}
