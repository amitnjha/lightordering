package com.labs1904.lightordering.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.labs1904.lightordering.dto.UserDto;
import com.labs1904.lightordering.mapper.UserMapper;
import com.labs1904.lightordering.repository.UserRepository;

import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/v1/users")
public class UserController {
	
	@Autowired
	UserRepository userRepository;

	@Autowired
	UserMapper userMapper;
	
	@Autowired
	public UserController(UserRepository userRepository, UserMapper userMapper) {
		this.userRepository = userRepository;
		this.userMapper = userMapper;
	}
	
	@ApiOperation("Creates a new User")
	@RequestMapping(path = "/user", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserDto> createUser(@RequestBody UserDto request){
		return new ResponseEntity<>(request, HttpStatus.CREATED);
	}
}
