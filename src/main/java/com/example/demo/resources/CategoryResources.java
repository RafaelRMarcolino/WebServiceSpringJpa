package com.example.demo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Category;
import com.example.demo.services.CategoryServices;

@RestController
@RequestMapping(value="/category")
public class CategoryResources { 
	
	@Autowired
	private CategoryServices services;
	
	@RequestMapping(method = RequestMethod.GET) 
	public ResponseEntity<List<Category>> findAll(){
		
		List<Category> list = services.find();
		return ResponseEntity.ok().body(list);
		
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Category> findbyId(@PathVariable Long id){
		
		Category obj = services.findById(id);
		return ResponseEntity.ok().body(obj);
		
	}
	
	

}
