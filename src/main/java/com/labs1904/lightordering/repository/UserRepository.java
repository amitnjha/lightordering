package com.labs1904.lightordering.repository;

import org.springframework.data.repository.CrudRepository;

import com.labs1904.lightordering.entity.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, Integer>{

}
