package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Order;
import com.example.demo.repository.OrderRepository;

@Service
public class OrderServices {

	@Autowired	
	private OrderRepository repo;
	
	public List<Order> find(){
			
		return repo.findAll();
	}
	
	public Order findById(Long id) {
		Optional<Order> obj = repo.findById(id);
		return obj.orElse(null);
		
	}
}
