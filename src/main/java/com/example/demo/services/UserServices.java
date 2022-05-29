package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Users;
import com.example.demo.repository.UserRepository;
import com.example.demo.services.exception.DataBaseException;
import com.example.demo.services.exception.ResourceNotFoundException;

@Service
public class UserServices {

	@Autowired
	private UserRepository repo;

	public List<Users> find() {

		return repo.findAll();
	}

	public Users findById(Long id) {
		Optional<Users> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));

	}

	public Users insert(Users obj) {
		return repo.save(obj);
	}

	public void delete(Long id) {
		try {
			repo.deleteById(id);

		}catch (EmptyResultDataAccessException e) {
			
			throw new ResourceNotFoundException(id);
		}/*
		saber qual sera a excecao
		
		catch (RuntimeException e) {

			e.printStackTrace();
		
		}*/
		
		catch(DataIntegrityViolationException e) {
			
			throw new DataBaseException(e.getMessage());
			
		}
		
	}

	public Users update(Long id, Users obj) {
		try {

			Users entity = repo.getById(id);
			updateData(entity, obj);
			return repo.save(entity);

		}/* achar a excecao
		
		catch (RuntimeException e) {

			e.printStackTrace();
			throw new ResourceNotFoundException(id);

		}*/
		catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);

		}
	}

	private void updateData(Users entity, Users obj) {

		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());

	}

}
