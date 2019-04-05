package com.labs1904.lightordering.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

import com.labs1904.lightordering.dto.CustomerDto;
import com.labs1904.lightordering.entity.CustomerEntity;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface CustomerMapper {
	public CustomerDto entityToDto(CustomerEntity entity);
	public CustomerEntity dtoToEntity(CustomerDto dto);

}
