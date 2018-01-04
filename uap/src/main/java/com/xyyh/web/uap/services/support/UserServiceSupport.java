package com.xyyh.web.uap.services.support;

import javax.cache.annotation.CacheRemoveAll;
import javax.cache.annotation.CacheResult;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xyyh.web.common.uap.dto.UserDto;
import com.xyyh.web.uap.converter.UserConverter;
import com.xyyh.web.uap.entity.User;
import com.xyyh.web.uap.repositories.UserRepository;
import com.xyyh.web.uap.services.UserService;

@Service
public class UserServiceSupport implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private UserConverter userConverter;

	@Override
	public User loadById(long id) {
		return userRepository.findOne(id);
	}

	@Override
	@Transactional
	@CacheRemoveAll(cacheName = "user")
	public User save(UserDto user) {
		String password = user.getPassword();
		if (StringUtils.isBlank(password)) {
			password = "";
		}
		if (password.length() < 30) {
			password = passwordEncoder.encode(password);
		}
		User user_ = new User();
		userConverter.copyProperties(user_, user);
		user_.setPassword(password);
		user_ = userRepository.save(user_);
		return user_;
	}

	@Override
	@Transactional
	@CacheRemoveAll(cacheName = "user")
	public User update(UserDto user) {
		User user_ = userRepository.getOne(user.getId());
		if (user_ != null) {
			userConverter.copyProperties(user_, user);
		}
		return user_;
	}

	@Override
	@Transactional
	public void changePasswordById(long userId, String password) {
		User user = userRepository.findOne(userId);
		if (user != null) {
			user.setPassword(passwordEncoder.encode(password));
		}
	}

	@Override
	@CacheResult(cacheName = "user")
	public User loadByUserName(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public Page<User> findByUsername(String username, Pageable pageable) {
		return userRepository.findByUsernameContaining(username, pageable);
	}

}