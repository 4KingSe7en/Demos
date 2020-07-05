package com.demo.jwt;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.demo.SimpleAuthorizationServerApplicaiton;

@SpringBootTest(classes = SimpleAuthorizationServerApplicaiton.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class JWTTokenGeneratorTest {
	
	@Autowired
	JWTTokenGenerator generator;

	@Test
	public void generateJwtTest() {
		String account = "sph";
		String token = generator.getOrCreat(account);
		assertNotNull(token);
		
		String token2 = generator.getOrCreat(account);
		assertTrue(token == token2);
	}
}
