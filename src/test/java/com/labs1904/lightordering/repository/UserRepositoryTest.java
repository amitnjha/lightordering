package com.labs1904.lightordering.repository;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.labs1904.lightordering.TestDataUtils;
import com.labs1904.lightordering.entity.UserEntity;

@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class UserRepositoryTest {

	@Autowired
	TestEntityManager tem;
	
	@Autowired
	UserRepository repository;
	
	String email;
	
	@Before
	public void setUp() {
		UserEntity entity = TestDataUtils.createUserEntity();
		email = entity.getEmail();
		tem.persistAndFlush(entity);
	}
	
	@Test
	public void findUserByEmail() {
		System.out.println(String.format("Email is - ",email));
		assertEquals("Did not return 1 user",repository.findByEmail(email).size(),1);
		
	}
	
}