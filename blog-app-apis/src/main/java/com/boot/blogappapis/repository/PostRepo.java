package com.boot.blogappapis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.blogappapis.entities.Category;
import com.boot.blogappapis.entities.Post;
import com.boot.blogappapis.entities.User;

public interface PostRepo extends JpaRepository<Post, Integer>{
	
	List<Post> findByUser(User user);
	
	List<Post> findByCategory(Category category);
	
	List<Post> findByTitleContaining(String title);
}
