package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Product;
import com.example.demo.repository.ProductRepository;

@Service
public class ProductServices {

	@Autowired	
	private ProductRepository repo;
	
	public List<Product> find(){
			
		return repo.findAll();
	}
	
	public Product findById(Long id) {
		Optional<Product> obj = repo.findById(id);
		return obj.orElse(null);
		
	}
}
