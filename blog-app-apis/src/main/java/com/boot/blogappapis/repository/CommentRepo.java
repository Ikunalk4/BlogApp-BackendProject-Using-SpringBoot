package com.boot.blogappapis.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.blogappapis.entities.Comment;

public interface CommentRepo extends JpaRepository<Comment, Integer>{
		
}
