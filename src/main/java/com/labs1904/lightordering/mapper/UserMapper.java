package com.labs1904.lightordering.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

import com.labs1904.lightordering.dto.UserDto;
import com.labs1904.lightordering.entity.UserEntity;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface UserMapper {
	
	public UserDto entityToDto(UserEntity entity);
	public UserEntity dtoToEntity(UserDto dto);

}
