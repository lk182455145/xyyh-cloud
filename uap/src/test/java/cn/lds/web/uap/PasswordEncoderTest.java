package cn.lds.web.uap;

import java.util.Calendar;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.Before;
import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordEncoderTest {

	private PasswordEncoder passwordEncoder;

	@Before
	public void init() {
		passwordEncoder = new BCryptPasswordEncoder();
	}

	@Test
	public void testEncode() {
		String password = "booot";
		System.out.println(passwordEncoder.encode(password));
	}

	@Test
	public void testMatch() {
		String s = "$2a$10$JPaumbSFHJEnt9QPe.tsSev7Uf4zidQlT59xsAxP8tB7pa/j8exoy";
		long start = Calendar.getInstance().getTime().getTime();
		for (int i = 0; i < 1000; i++) {
			passwordEncoder.matches("booot", s);
		}
		long use = Calendar.getInstance().getTime().getTime() - start;
		System.out.println(use);
	}

	@Test
	public void testMatch2() {

	}

/*	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		for (int i = 0; i < 5; i++) {
			executorService.execute(new Mathcer(passwordEncoder));
		}
	}*/

	private static class Mathcer implements Runnable {
		private final PasswordEncoder passwordEncoder;
		private final String s = "$2a$10$JPaumbSFHJEnt9QPe.tsSev7Uf4zidQlT59xsAxP8tB7pa/j8exoy";

		public Mathcer(PasswordEncoder passwordEncoder) {
			this.passwordEncoder = passwordEncoder;
		}

		@Override
		public void run() {
			long start = Calendar.getInstance().getTime().getTime();
			for (int i = 0; i < 250; i++) {
				passwordEncoder.matches("booot", s);
			}
			long use = Calendar.getInstance().getTime().getTime() - start;
			System.out.println(use);
		}
	}

}
