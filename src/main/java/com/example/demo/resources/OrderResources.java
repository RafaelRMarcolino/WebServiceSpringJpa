package com.example.demo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Order;
import com.example.demo.services.OrderServices;

@RestController
@RequestMapping(value="/orders")
public class OrderResources { 
	
	@Autowired
	private OrderServices services;
	
	@RequestMapping(method = RequestMethod.GET) 
	public ResponseEntity<List<Order>> findAll(){
		
		List<Order> list = services.find();
		return ResponseEntity.ok().body(list);
		
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Order> findbyId(@PathVariable Long id){
		
		Order obj = services.findById(id);
		return ResponseEntity.ok().body(obj);
		
	}
	
	

}
