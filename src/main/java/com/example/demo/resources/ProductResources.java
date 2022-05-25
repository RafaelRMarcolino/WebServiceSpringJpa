package com.example.demo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Product;
import com.example.demo.services.ProductServices;

@RestController
@RequestMapping(value="/product")
public class ProductResources { 
	
	@Autowired
	private ProductServices services;
	
	@RequestMapping(method = RequestMethod.GET) 
	public ResponseEntity<List<Product>> findAll(){
		
		List<Product> list = services.find();
		return ResponseEntity.ok().body(list);
		
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Product> findbyId(@PathVariable Long id){
		
		Product obj = services.findById(id);
		return ResponseEntity.ok().body(obj);
		
	}
	
	

}
