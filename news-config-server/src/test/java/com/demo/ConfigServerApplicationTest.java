package com.demo;

import static org.junit.Assert.assertEquals;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.DEFINED_PORT;

import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * news config server tests
 * 
 * @author Larry_lee
 * @since 2020-07-03
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = DEFINED_PORT)
public class ConfigServerApplicationTest {
	
	Logger logger = LoggerFactory.getLogger(ConfigServerApplicationTest.class);
	
	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void configurationAvailable() {
		@SuppressWarnings("rawtypes")
		ResponseEntity<Map> entity = restTemplate.getForEntity("/service-registry.yml", Map.class);
		logger.info("resp : {}" , entity);
		assertEquals(HttpStatus.OK, entity.getStatusCode());
	}

}