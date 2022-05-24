package com.example.demo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Users;
import com.example.demo.services.UserServices;

@RestController
@RequestMapping(value="/usuarios")
public class UserResources {
	
	@Autowired
	private UserServices services;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Users>> findAll(){
		
		List<Users> list = services.find();
		return ResponseEntity.ok().body(list);
		
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Users> findbyId(@PathVariable Long id){
		
		Users obj = services.findById(id);
		return ResponseEntity.ok().body(obj);
		
	}
	
	

}
