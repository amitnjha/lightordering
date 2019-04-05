package com.labs1904.lightordering.repository;

import java.util.List;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

import com.labs1904.lightordering.entity.CustomerEntity;

public interface CustomerRepository extends CrudRepository<CustomerEntity, Integer>, QuerydslPredicateExecutor<CustomerEntity> {
	List<CustomerEntity> findByEmail(String email);
	List<CustomerEntity> findByFirstNameAndLastName(String firstName, String lastName);
	CustomerEntity findBySsn(String ssn);
	
}
