package com.xyyh.web.uap.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xyyh.web.common.uap.dto.UserDetailsDto;
import com.xyyh.web.common.uap.dto.UserDto;
import com.xyyh.web.uap.converter.UserConverter;
import com.xyyh.web.uap.entity.User;
import com.xyyh.web.uap.services.UserService;

@RestController
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserService userSerivce;

	@Autowired
	private UserConverter userConverter;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@RequestMapping(value = "{userName}", method = RequestMethod.GET)
	public UserDetailsDto loadByUserName(@PathVariable("userName") String username) {
		try {
			User user = userSerivce.loadByUserName(username);
			return userConverter.toDetailsDto(user);
		} catch (Exception e) {
			return null;
		}
	}

	@RequestMapping(method = RequestMethod.POST)
	public UserDto save(UserDto user) {
		User user_ = userSerivce.save(user);
		return userConverter.toDto(user_);
	}

	@RequestMapping(value = "{username}/{password}", method = RequestMethod.GET)
	public boolean checkPassword(@PathVariable("username") String username, @PathVariable("password") String password) {
		User user = userSerivce.loadByUserName(username);
		return passwordEncoder.matches(password, user.getPassword());
	}

	@RequestMapping(method = RequestMethod.PUT)
	public UserDto update(@ModelAttribute final UserDto userDto) {
		userSerivce.update(userDto);
		return userDto;
	}

	@RequestMapping(method = RequestMethod.PUT, value = "{userId}/{password}")
	public boolean changePassword(@PathVariable("userId") Long userId, String oldPassword,
			@PathVariable("password") String newPassword) {
		try {
			userSerivce.changePasswordById(userId, newPassword);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<User> findByName(@RequestParam(value = "username", required = false, defaultValue = "") String username,
			Pageable pageRequest) {
		return userSerivce.findByUsername(username, pageRequest).getContent();
	}

}
