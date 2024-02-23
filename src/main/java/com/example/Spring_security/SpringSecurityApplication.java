package com.example.Spring_security;

import com.example.Spring_security.domain.Role;
import com.example.Spring_security.domain.User;
import com.example.Spring_security.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class SpringSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityApplication.class, args);
	}

	@Bean
	BCryptPasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

@Bean
	CommandLineRunner run(UserService  userService){
		return args -> {
			userService.saveRole(new Role(null,"ROLE_USER"));
			userService.saveRole(new Role(null,"ROLE_MANAGER"));
			userService.saveRole(new Role(null,"ROLE_ADMIN"));
			userService.saveRole(new Role(null,"ROLE_SUPER_ADMIN"));


			userService.saveUser(new User(null,"Jone Smith","jone","123",new ArrayList<>()));
			userService.saveUser(new User(null,"Anne Keri","anne","123",new ArrayList<>()));
			userService.saveUser(new User(null,"Wilson Jondan","wilson","123",new ArrayList<>()));
			userService.saveUser(new User(null,"Jaki Lotas","jaki","123",new ArrayList<>()));
			userService.saveUser(new User(null,"Van Dam","van","123",new ArrayList<>()));

			userService.addRoleToUser("jone","ROLE_USER");
			userService.addRoleToUser("jone","ROLE_SUPER_ADMIN");
			userService.addRoleToUser("jone","ROLE_ADMIN");
			userService.addRoleToUser("jone","ROLE_MANAGER");
			userService.addRoleToUser("anne","ROLE_MANAGER");
			userService.addRoleToUser("wilson","ROLE_ADMIN");
			userService.addRoleToUser("Van","ROLE_SUPER_ADMIN");
			userService.addRoleToUser("Jaki","ROLE_USER");


		};
	}

}
