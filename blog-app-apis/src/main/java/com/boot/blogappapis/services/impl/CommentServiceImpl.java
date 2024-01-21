package com.boot.blogappapis.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.blogappapis.entities.Comment;
import com.boot.blogappapis.entities.Post;
import com.boot.blogappapis.exceptions.ResourceNotFoundException;
import com.boot.blogappapis.payloads.CommentDto;
import com.boot.blogappapis.repository.CommentRepo;
import com.boot.blogappapis.repository.PostRepo;
import com.boot.blogappapis.services.CommentService;

@Service
public class CommentServiceImpl implements CommentService{
	
	@Autowired
	private PostRepo postRepo;
	
	@Autowired
	private CommentRepo commentRepo;
	
	@Autowired
	private ModelMapper modelMapper; 

	@Override
	public CommentDto createComment(CommentDto commentDto, Integer postId) {
		
		Post post = this.postRepo.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "post id", postId));
		Comment comment = this.modelMapper.map(commentDto, Comment.class);
		comment.setPost(post);
		Comment savedComment = this.commentRepo.save(comment);
		return this.modelMapper.map(savedComment, CommentDto.class);
	}

	@Override
	public void deleteComment(Integer commentId) {
		
		Comment com = this.commentRepo.findById(commentId)
				.orElseThrow(() -> new ResourceNotFoundException("Comment", "comment id", commentId));
		this.commentRepo.delete(com);
	}

}
