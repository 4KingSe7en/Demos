package com.demo;

import static org.junit.Assert.assertEquals;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.DEFINED_PORT;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.MultiValueMap;

import com.google.gson.GsonBuilder;

/**
 * 
 * @author Larry_lee
 * @since 2020-07-03
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = DEFINED_PORT)
public class ApiGatewayTest {

	Logger logger = LoggerFactory.getLogger(ApiGatewayTest.class);

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void apiAvailable() {
		Map<String, String> user = new HashMap<String, String>();
		user.put("account", "sph");
		user.put("password", "111");
		user.put("userType", "APP");
		@SuppressWarnings("rawtypes")
		ResponseEntity<Map> entity = restTemplate.postForEntity("/login", new GsonBuilder().create().toJson(user),
				Map.class);
		logger.info("resp : {}", entity);
		// 因为是单元测试服务没起
		assertEquals(HttpStatus.NOT_FOUND, entity.getStatusCode());
	}

	@Test
	public void registTest() {
		Map<String, String> user = new HashMap<String, String>();
		user.put("account", "sph");
		user.put("password", "111");
		user.put("userType", "APP");
		@SuppressWarnings("rawtypes")
		ResponseEntity<Map> entity = restTemplate.postForEntity("/user/regist", new GsonBuilder().create().toJson(user),
				Map.class);
		logger.info("resp : {}", entity);
		assertEquals(HttpStatus.NOT_FOUND, entity.getStatusCode());
	}

	@Test
	public void webAppTest() {
		@SuppressWarnings("rawtypes")
		ResponseEntity<Map> entity = restTemplate.getForEntity("/app/news", Map.class);
		logger.info("resp : {}", entity);
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, entity.getStatusCode());
	}

	@Test
	public void webAppHeaderTest() {
		HttpHeaders header = new HttpHeaders();
		header.add("Authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJTUEgiLCJuYW1lIjoic3BoIiwiZXhwIjoxNTk0MDE4NTEyLCJpYXQiOjE1OTQwMTU1MTJ9.ggSvcUvELjZ3omawGHFYPIqbCp0lowx73G1PPOf3Xj8");
		HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity<>(header);
		@SuppressWarnings("rawtypes")
		ResponseEntity<Map> entity = restTemplate.exchange("/app/news",HttpMethod.GET,httpEntity, Map.class);
		logger.info("resp : {}", entity);
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, entity.getStatusCode());
	}

	@Test
	public void webAdminTest() {
		@SuppressWarnings("rawtypes")
		ResponseEntity<Map> entity = restTemplate.getForEntity("/admin/news", Map.class);
		logger.info("resp : {}", entity);
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, entity.getStatusCode());
	}

	@Test
	public void webAdminHeaderTest() {
		HttpHeaders header = new HttpHeaders();
		header.add("Authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJTUEgiLCJuYW1lIjoic3BoIiwiZXhwIjoxNTk0MDE4NTEyLCJpYXQiOjE1OTQwMTU1MTJ9.ggSvcUvELjZ3omawGHFYPIqbCp0lowx73G1PPOf3Xj8");
		HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity<>(header);
		@SuppressWarnings("rawtypes")
		ResponseEntity<Map> entity = restTemplate.exchange("/admin/news",HttpMethod.GET,httpEntity, Map.class);
		logger.info("resp : {}", entity);
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, entity.getStatusCode());
	}
}
