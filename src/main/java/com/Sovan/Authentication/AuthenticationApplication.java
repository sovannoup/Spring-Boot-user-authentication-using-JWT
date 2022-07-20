package com.Sovan.Authentication;

import com.Sovan.Authentication.domain.Role;
import com.Sovan.Authentication.domain.User;
import com.Sovan.Authentication.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.Array;
import java.util.ArrayList;

@SpringBootApplication
public class AuthenticationApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthenticationApplication.class, args);
	}

	@Bean
	CommandLineRunner run(UserService userService){
		return args -> {
			userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));
			userService.saveRole(new Role(null, "ROLE_EMPLOYEE"));
			userService.saveRole(new Role(null, "ROLE_USER"));

			userService.saveUser(new User(null, "Noup Sovan", "Sovan", "noupsovan18@gmail.com", "12345", new ArrayList<>()));
			userService.saveUser(new User(null, "Thou Theara", "Theara", "theararemix@gmail.com", "12345", new ArrayList<>()));

			userService.addRoleToUser("Sovan", "ROLE_SUPER_ADMIN");
			userService.addRoleToUser("Theara", "ROLE_SUPER_ADMIN");
		};
	}

}
