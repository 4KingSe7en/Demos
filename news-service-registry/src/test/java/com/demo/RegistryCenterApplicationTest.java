package com.demo;

import static org.junit.Assert.assertEquals;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.DEFINED_PORT;

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
 * unit test for Registry center
 * 
 * @author Larry_lee
 * @since 2020-07-03
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = DEFINED_PORT)
public class RegistryCenterApplicationTest {

	Logger logger = LoggerFactory.getLogger(RegistryCenterApplicationTest.class);

	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	public void catalogLoads() {
		ResponseEntity<String> entity = restTemplate.getForEntity("/", String.class);
		//logger.info("{}", entity);
		assertEquals(HttpStatus.OK, entity.getStatusCode());
	}

}
