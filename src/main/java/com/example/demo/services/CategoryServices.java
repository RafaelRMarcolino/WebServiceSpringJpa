package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Category;
import com.example.demo.repository.CategoryRepository;

@Service
public class CategoryServices {

	@Autowired	
	private CategoryRepository repo;
	
	public List<Category> find(){
			
		return repo.findAll();
	}
	
	public Category findById(Long id) {
		Optional<Category> obj = repo.findById(id);
		return obj.orElse(null);
		
	}
}
