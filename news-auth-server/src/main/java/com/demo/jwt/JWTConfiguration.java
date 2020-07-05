package com.demo.jwt;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.auth0.jwt.algorithms.Algorithm;

/**
 * JWT Creator configuration
 * 
 * @author Larry_lee
 * @since 2020-07-05
 */
@Configuration
public class JWTConfiguration {
	
	@Bean
	public Algorithm algorithm(@Value("${server.jwt.secret}") String secret) 
			throws NoSuchAlgorithmException, InvalidKeySpecException {
		return Algorithm.HMAC256(secret);
	}
	
}