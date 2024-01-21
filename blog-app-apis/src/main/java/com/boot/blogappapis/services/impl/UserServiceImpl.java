package com.boot.blogappapis.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.blogappapis.entities.User;
import com.boot.blogappapis.exceptions.ResourceNotFoundException;
import com.boot.blogappapis.payloads.UserDto;
import com.boot.blogappapis.repository.UserRepo;
import com.boot.blogappapis.services.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private ModelMapper moodelMapper;

	@Override
	public UserDto createUser(UserDto userDto) {
		
		User user = this.dtoToUser(userDto);
		User savedUser = this.userRepo.save(user);
		return this.userToDto(savedUser);
	}

	@Override
	public UserDto updateUser(UserDto userDto, Integer userId) {
		User user = this.userRepo.findById(userId)
				.orElseThrow(()-> new ResourceNotFoundException("User","id",userId));
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setAbout(userDto.getAbout());
		user.setPassword(userDto.getPassword());
		
		User updatedUser = this.userRepo.save(user);
		UserDto userToDto1 = this.userToDto(updatedUser);
		return userToDto1;
	}

	@Override
	public UserDto getUserById(Integer userId) {
		User user = this.userRepo.findById(userId)
				.orElseThrow(()-> new ResourceNotFoundException("User", " Id ", userId));
		return this.userToDto(user);
	}

	@Override
	public List<UserDto> getAllUsers() {
		
		List<User> users = this.userRepo.findAll();
		List<UserDto> userDtos = users.stream().map(user-> this.userToDto(user))
			.collect(Collectors.toList());
		
		return userDtos;
	}

	@Override
	public void deleteUser(Integer userId) {
		User user = this.userRepo.findById(userId)
				.orElseThrow(()-> new ResourceNotFoundException("User", " Id ", userId));
		this.userRepo.delete(user);

	}
	public User dtoToUser(UserDto userDto) {
		User user = this.moodelMapper.map(userDto, User.class);
		
	//		user.setId(userDto.getId());
	//		user.setName(userDto.getName());
	//		user.setPassword(userDto.getPassword());
	//		user.setEmail(userDto.getEmail());
	//		user.setAbout(userDto.getAbout());
		return user;
	}
	
	public UserDto userToDto(User user) {
		UserDto userDto = this.moodelMapper.map(user, UserDto.class);
		return userDto;
	}

}
