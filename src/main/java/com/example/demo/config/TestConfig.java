package com.example.demo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.demo.domain.Users;
import com.example.demo.repository.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRespository;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Users u1 = new Users(null, "joao", "joao@gmail", "119555888", "888877");
		Users u2 = new Users(null, "joao", "joao@gmail", "119555888", "888877");
		
		userRespository.saveAll(Arrays.asList(u1, u2));
		
	}

}
