package com.demo.jwt;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.demo.SimpleAuthorizationServerApplicaiton;
import com.demo.controller.UserLoginControllerTest;

@SpringBootTest(classes = SimpleAuthorizationServerApplicaiton.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class JWTTokenGeneratorTest {
	
	Logger logger = LoggerFactory.getLogger(UserLoginControllerTest.class);
	
	@Autowired
	JWTTokenGenerator generator;

	@Test
	public void generateJwtTest() {
		String account = "sph";
		String token = generator.getOrCreat(account);
		logger.info("Token : {}",token);
		assertNotNull(token);
		
		String token2 = generator.getOrCreat(account);
		logger.info("Token2 : {}",token);
		assertTrue(token == token2);
	}
}
