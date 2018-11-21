package com.labs1904.lightordering.repository;

import java.util.List;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

import com.labs1904.lightordering.entity.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, Integer>, QuerydslPredicateExecutor<UserEntity> {

	List<UserEntity> findByEmail(String email);
};
