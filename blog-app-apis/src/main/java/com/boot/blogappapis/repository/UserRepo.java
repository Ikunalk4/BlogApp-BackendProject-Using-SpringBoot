package com.boot.blogappapis.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.blogappapis.entities.User;

public interface UserRepo extends JpaRepository<User, Integer>{
		
	Optional<User> findByEmail(String email);
}
