package com.boot.blogappapis.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;

import com.boot.blogappapis.repository.UserRepo;

public class CustomUserDetailService extends UserDetailsServiceAutoConfiguration{
	
	@Autowired
	private UserRepo repo;
}
