package com.demo.jwt;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

/**
 * unit test for jwtUnti
 * @author Larry_lee
 * @since 2020-07-04
 */
public class JwtUtilTest {
	
	@Test
	public void generateJwtTest() {
		String account = "sph";
		String token = JwtUtil.generateJwtToken(account,null);
		assertNotNull(token);
	}
	
	@Test
	public void checkJwtValidTest() {
		String account = "sph";
		String token = JwtUtil.generateJwtToken(account,null);
		String result = JwtUtil.checkToken(token);
		assertNotNull(result);
	}
	
	@Test
	public void checkJwtExpireTest() {
		String account = "sph";
		long expireTime = 2L;
		String token = JwtUtil.generateJwtToken(account,expireTime);
		String result = JwtUtil.checkToken(token);
		assertNotNull(result);
	}
	
}
