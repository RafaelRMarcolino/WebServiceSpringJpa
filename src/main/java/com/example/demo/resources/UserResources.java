package com.example.demo.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	@PostMapping
	public ResponseEntity<Users> insert(@RequestBody Users obj){
		
		obj = services.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		services.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Users> update(@PathVariable Long id, @RequestBody Users obj){
		
		obj =  services.update(id, obj);
		return ResponseEntity.ok().body(obj);
		
	}

}
