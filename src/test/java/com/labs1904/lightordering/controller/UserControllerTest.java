package com.labs1904.lightordering.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.labs1904.lightordering.LighorderingApplication;
import com.labs1904.lightordering.TestDataUtils;
import com.labs1904.lightordering.dto.UserDto;
import com.labs1904.lightordering.entity.UserEntity;
import com.labs1904.lightordering.mapper.UserMapper;
import com.labs1904.lightordering.mapper.UserMapperImpl;
import com.labs1904.lightordering.repository.UserRepository;

@ActiveProfiles("test")
@SpringBootTest(classes = LighorderingApplication.class, webEnvironment=SpringBootTest.WebEnvironment.MOCK)
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class UserControllerTest {

	@Autowired
	MockMvc mockMvc;
	
	//@MockBean
	
	UserRepository userRepository;
	
	//@MockBean
	
	//UserMapper userMapper;
	
	ObjectMapper mapper = new ObjectMapper();
	
	UserMapper mapperImpl = new UserMapperImpl();
	
	@Before
	public void setUp() {
		
	}
	
	@Test
	public void createUser() throws Exception {
	
		UserDto  dto = TestDataUtils.createUserDto();
		UserEntity entity = mapperImpl.dtoToEntity(dto);
		// Mockito.when(this.userRepository.findByEmail(dto.getEmail())).thenReturn(new ArrayList());
		//Mockito.when(userMapper.dtoToEntity(eq(dto))).thenReturn(entity);
		//Mockito.when(userMapper.entityToDto(eq(entity))).thenReturn(dto);
		//Mockito.when(this.userRepository.save(eq(entity))).thenReturn(entity);
		this.mockMvc.perform(MockMvcRequestBuilders
				.post("/v1/users/user")
				.content(mapper.writeValueAsString(dto))
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers.status().isCreated())
		.andExpect(MockMvcResultMatchers.jsonPath("$.firstName").value(dto.getFirstName()));
		
	}
	
	@Test
	public void createUserDuplicate() throws Exception {
	
		UserDto  dto = TestDataUtils.createUserDto();
		UserEntity entity = mapperImpl.dtoToEntity(dto);
		// Mockito.when(this.userRepository.findByEmail(dto.getEmail())).thenReturn(new ArrayList());
		//Mockito.when(userMapper.dtoToEntity(eq(dto))).thenReturn(entity);
		//Mockito.when(userMapper.entityToDto(eq(entity))).thenReturn(dto);
		//Mockito.when(this.userRepository.save(eq(entity))).thenReturn(entity);
		this.mockMvc.perform(MockMvcRequestBuilders
				.post("/v1/users/user")
				.content(mapper.writeValueAsString(dto))
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers.status().isCreated())
		.andExpect(MockMvcResultMatchers.jsonPath("$.firstName").value(dto.getFirstName()));
		
		this.mockMvc.perform(MockMvcRequestBuilders
				.post("/v1/users/user")
				.content(mapper.writeValueAsString(dto))
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers.status().is5xxServerError());
	}
	
//	@Test
//	public void updateUser()throws Exception {
//		UserDto dto = TestDataUtils.createUserDto();
//		UserEntity entity = mapperImpl.dtoToEntity(dto);
//		
//		this.mockMvc.perform(MockMvcRequestBuilders
//				.post("/v1/users/user")
//				.content(mapper.writeValueAsString(dto))
//				.contentType(MediaType.APPLICATION_JSON))
//		.andExpect(MockMvcResultMatchers.status().isCreated());
//		
//		this.mockMvc.perform(MockMvcRequestBuilders
//				.put("/v1/users/user")
//				.content(mapper.writeValueAsString(dto))
//				.contentType(MediaType.APPLICATION_JSON))
//		.andExpect(MockMvcResultMatchers.status().isAccepted());
//		
//	}
	
}
