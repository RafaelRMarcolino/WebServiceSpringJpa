package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.Users;

public interface UserRepository  extends JpaRepository<Users, Long> {

}
