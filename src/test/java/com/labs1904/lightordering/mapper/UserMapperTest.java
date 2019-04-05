package com.labs1904.lightordering.mapper;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.labs1904.lightordering.TestDataUtils;
import com.labs1904.lightordering.dto.UserDto;
import com.labs1904.lightordering.entity.UserEntity;

@ActiveProfiles("test")
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class UserMapperTest {

	@Autowired
	UserMapper mapper;
	
	@Test
	public void entityToDto() {
		UserEntity userEntity = TestDataUtils.createUserEntity();
		UserDto dto = mapper.entityToDto(userEntity);
		
		assertEquals("Did not map first name", dto.getFirstName(), userEntity.getFirstName());
		assertEquals("Did not map last name", dto.getLastName(), userEntity.getLastName());
		assertEquals("Did not map email", dto.getEmail(), userEntity.getEmail());
		assertEquals("Did not map id", dto.getId(), userEntity.getId());
	}
	
	@Test
	public void dtoToEntity() {
		UserDto dto =  TestDataUtils.createUserDto();
		UserEntity userEntity =  mapper.dtoToEntity(dto);
		assertEquals("Did not map first name", dto.getFirstName(), userEntity.getFirstName());
		assertEquals("Did not map last name", dto.getLastName(), userEntity.getLastName());
		assertEquals("Did not map email", dto.getEmail(), userEntity.getEmail());
		assertEquals("Did not map id", dto.getId(), userEntity.getId());
	}
}
