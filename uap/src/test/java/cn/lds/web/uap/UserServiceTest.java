package cn.lds.web.uap;

import java.util.Calendar;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xyyh.web.common.uap.dto.UserDto;
import com.xyyh.web.uap.UapApplication;
import com.xyyh.web.uap.services.UserService;

import reactor.Environment;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = UapApplication.class)
public class UserServiceTest {

	@Autowired
	private UserService userService;

	@Autowired
	private Environment environment;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Test
	public void testNewUser() {
		UserDto user = new UserDto();
		user.setUsername("lidong7");
		System.out.println(userService.save(user));
		System.out.println("complate");
	}

	@Test
	public void updateUser() {
		UserDto user = new UserDto();
		user.setId(12L);
		user.setUsername(String.valueOf(Calendar.getInstance().getTime().getTime()));
		System.out.println(userService.update(user));
	}

	@Test
	public void testChangePassword() {
		userService.changePasswordById(12, "good");
	}

	@Test
	public void testReactor() {
		System.out.println(environment);
	}

	@Test
	public void testEncode() {
		String password = "booot";
		System.out.println(passwordEncoder.encode(password));
	}

	@Test
	public void testMatch() {
		String st = "$2a$10$06SBgQ4rFIcJ9sU1j3pNlek5dKOEsqv4WJiSEC0hPE3iUXlqXeeVC";
		System.out.println(passwordEncoder.matches("booot", st));
	}

}
