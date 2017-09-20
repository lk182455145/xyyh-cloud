package com.xyyh.web.portal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xyyh.web.gateway.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestUserService {

	@Autowired
	private UserService userService;

	@Test
	public void testGetUser() {
		// UserDto user = userService.getUser(13);
		// System.out.println(user);
	}

}
