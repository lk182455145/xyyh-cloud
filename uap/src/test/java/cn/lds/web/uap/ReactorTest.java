package cn.lds.web.uap;

import java.util.Calendar;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import reactor.Environment;

public class ReactorTest {

	public static void main(String[] args) throws InterruptedException {
		final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		Environment.initialize();
		for (int j = 0; j < 4; j++) {
			Environment.sharedDispatcher().dispatch("$2a$10$JPaumbSFHJEnt9QPe.tsSev7Uf4zidQlT59xsAxP8tB7pa/j8exoy",
					(s) -> {
						// System.out.println(s);
						long start = Calendar.getInstance().getTime().getTime();
						for (int i = 0; i < 250; i++) {
							passwordEncoder.matches("booot", s);
							System.out.println(i);
						}
						long use = Calendar.getInstance().getTime().getTime() - start;
						System.out.println(use);
					}, (e) -> {

					});
		}
		Thread.sleep(100000);
	}

}
