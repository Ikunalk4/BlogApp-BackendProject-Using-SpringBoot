package com.boot.blogappapis.services;

import java.util.List;

import com.boot.blogappapis.entities.Post;
import com.boot.blogappapis.payloads.PostDto;
import com.boot.blogappapis.payloads.PostResponse;

public interface PostService {
	
	
	PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);
	
	PostDto updatePost(PostDto postDto, Integer postId);
	
	void deletePost(Integer postId);
	
	PostResponse getAllPost(Integer pageNumber, Integer pageSize,String sortBy, String sortDir);
	
	PostDto getPostById(Integer postId);
	
	List<PostDto> getPostByCategory(Integer categoryId);
	
	List<PostDto> getPostByUser(Integer userid);
	
	List<PostDto> searchPosts(String keyword);
}
