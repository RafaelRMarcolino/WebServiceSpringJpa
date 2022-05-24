package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Users;
import com.example.demo.repository.UserRepository;

@Service
public class UserServices {

	@Autowired
	private UserRepository repo;
	
	public List<Users> find(){
			
		return repo.findAll();
	}
	
	public Users findById(Long id) {
		Optional<Users> obj = repo.findById(id);
		return obj.orElse(null);
		
	}
}
