package com.labs1904.lightordering.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.labs1904.lightordering.dto.UserDto;
import com.labs1904.lightordering.entity.UserEntity;
import com.labs1904.lightordering.exception.ServerErrorException;
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
	
	@Transactional
	@ApiOperation("Creates a new User")
	@RequestMapping(path = "/user", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserDto> createUser(@RequestBody UserDto request) throws Exception{
		List<UserEntity> existingUsers = userRepository.findByEmail(request.getEmail());
		if (existingUsers.size() > 0) {
			throw new ServerErrorException(String.format("Found existing users with email %s %d",request.getEmail(), existingUsers.size()));//HttpServerErrorException(HttpStatus.INTERNAL_SERVER_ERROR,String.format("Found existing users with email %s %d",request.getEmail(), existingUsers.size()));
		}
		UserEntity entity = userRepository.save(userMapper.dtoToEntity(request));
		return new ResponseEntity<>(userMapper.entityToDto(entity), HttpStatus.CREATED);
	}
	
	@Transactional
	@ApiOperation("Update an existing user")
	@RequestMapping(path = "/user", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserDto> updateUser(@RequestBody UserDto request) {
		List<UserEntity> existingUsers = userRepository.findByEmail(request.getEmail());
		for (UserEntity entity : existingUsers) {
			if ( entity.getId() != request.getId()) {
				throw new DuplicateKeyException(String.format("Found existing users with email %s",request.getEmail()));
			}
		}
		UserEntity userEntity = userMapper.dtoToEntity(request);
		UserEntity newEntity =  userRepository.save(userEntity);
		return new ResponseEntity<>(userMapper.entityToDto(newEntity), HttpStatus.ACCEPTED);
	}
	
	
	@Transactional
	@ApiOperation("Delete an existing user")
	@RequestMapping(value = "/user/{userId}", method=RequestMethod.DELETE)
	public ResponseEntity deleteUser(@PathVariable int userId) {
		UserEntity entity = userRepository.findById(userId).get();
		if(entity == null) {
			throw new DataIntegrityViolationException(String.format("Could not find user with id %d", userId));
		}
		userRepository.delete(entity);
		return new ResponseEntity(HttpStatus.OK);
	}
	
	@Transactional
	@ApiOperation("Get user by email")
	@RequestMapping(value= "/user/{emailId}", method = RequestMethod.GET)
	public ResponseEntity<UserDto> getUserByEmail(@PathVariable String emailId) {
		List<UserEntity> users = userRepository.findByEmail(emailId);
		if(users.size() == 0) {
			throw new DataIntegrityViolationException("No User found");
		}
		if(users.size() > 1) {
			throw new DataIntegrityViolationException("Too many users with this email id");
		}
		return new ResponseEntity<UserDto>(userMapper.entityToDto(users.get(0)), HttpStatus.OK);
	}
	
}
