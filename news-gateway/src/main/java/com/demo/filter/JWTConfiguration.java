package com.demo.filter;

import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;

/**
 * Jwt configuration
 * @author Larry_lee
 * @since 2020-07-05
 */
@Configuration
public class JWTConfiguration {

	@Bean
	public JWTVerifier jwtVerifier(@Value("${server.jwt.secret}") String secret)
			throws IllegalArgumentException, UnsupportedEncodingException {

		return JWT.require(Algorithm.HMAC256(secret)).build();
	}
}
