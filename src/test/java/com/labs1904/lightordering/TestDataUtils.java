package com.labs1904.lightordering;

import java.util.Random;

import org.apache.commons.lang.RandomStringUtils;

import com.labs1904.lightordering.dto.UserDto;
import com.labs1904.lightordering.entity.UserEntity;

public class TestDataUtils {

	public static UserDto createUserDto() {
		UserDto dto = new UserDto();
		dto.setEmail(RandomStringUtils.randomAlphabetic(10));
		dto.setFirstName(RandomStringUtils.randomAlphanumeric(10));
		dto.setLastName(RandomStringUtils.randomAlphanumeric(10));
		dto.setId((new Random().nextInt()));
		return dto;
	
	}
	
	public static UserEntity createUserEntity() {
		UserEntity userEntity = new UserEntity();
		userEntity.setEmail(RandomStringUtils.randomAlphabetic(10));
		userEntity.setFirstName(RandomStringUtils.randomAlphanumeric(10));
		userEntity.setLastName(RandomStringUtils.randomAlphanumeric(10));
		return userEntity;
	
	}
}
