package com.boot.blogappapis.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.blogappapis.entities.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer>{
	
	
	
}
