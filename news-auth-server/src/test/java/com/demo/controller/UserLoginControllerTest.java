package com.demo.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.demo.SimpleAuthorizationServerApplicaiton;
import com.demo.jwt.JWTTokenGenerator;
import com.demo.param.UserParam;
import com.demo.user.enmu.UserType;
import com.demo.user.entity.User;
import com.demo.user.feign.SupportServiceClient;
import com.demo.web.ResponseMessage;

@SpringBootTest(classes = SimpleAuthorizationServerApplicaiton.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class UserLoginControllerTest {

	Logger logger = LoggerFactory.getLogger(UserLoginControllerTest.class);
	

	@InjectMocks
	@Autowired
	LoginController userLoginController;
	
	@Mock
	SupportServiceClient supportServiceClient;
	
	@Autowired
	JWTTokenGenerator generator;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void loginTest() {
		UserParam user = new UserParam();
		user.setAccount("sph");
		user.setPassword("111");
		user.setUserType(UserType.APP.name());
		
		User sysUser = new User();
		sysUser.setAccount(user.getAccount());
		sysUser.setPwd(user.getPassword());
		sysUser.setType(UserType.valueOf(user.getUserType()));
		
		when(supportServiceClient.userLogin(sysUser)).thenReturn(ResponseMessage.ok("nice"));
		ResponseMessage<String> resp = userLoginController.userLogin(user);
		logger.info("RESP:{}",resp);
		
		assertNotNull(resp);
		assertNotNull(resp.getResult());
	}
	
	@Test
	public void loginWithoutAccountTest() {
		UserParam user = new UserParam();
		user.setPassword("111");
		
		User sysUser = new User();
		sysUser.setAccount(user.getAccount());
		sysUser.setPwd(user.getPassword());
		sysUser.setType(UserType.valueOf(user.getUserType()));
		
		when(supportServiceClient.userLogin(sysUser)).thenReturn(ResponseMessage.error("account is require"));
		ResponseMessage<String> resp = userLoginController.userLogin(user);
		logger.info("RESP:{}",resp);
		
		assertNotNull(resp);
		assertEquals(resp.getCode(), 500);
	}
	
	@Test
	public void loginWithoutPasswordTest() {
		UserParam user = new UserParam();
		user.setAccount("sph");
		
		User sysUser = new User();
		sysUser.setAccount(user.getAccount());
		sysUser.setPwd(user.getPassword());
		sysUser.setType(UserType.valueOf(user.getUserType()));
		
		when(supportServiceClient.userLogin(sysUser)).thenReturn(ResponseMessage.error("password is require"));
		ResponseMessage<String> resp = userLoginController.userLogin(user);
		logger.info("RESP:{}",resp);
		
		assertNotNull(resp);
		assertEquals(resp.getCode(), 500);
	}
	
	@Test
	public void loginWithoutUserTypeTest() {
		UserParam user = new UserParam();
		user.setAccount("sph");
		user.setPassword("111");
		
		User sysUser = new User();
		sysUser.setAccount(user.getAccount());
		sysUser.setPwd(user.getPassword());
		sysUser.setType(UserType.valueOf(user.getUserType()));
		
		when(supportServiceClient.userLogin(sysUser)).thenReturn(ResponseMessage.ok("nice"));
		ResponseMessage<String> resp = userLoginController.userLogin(user);
		logger.info("RESP:{}",resp);
		
		assertNotNull(resp);
		assertEquals(resp.getCode(), 200);
	}
	
	@Test
	public void generateJwtTest() {
		String account = "sph";
		String token = generator.getOrCreat(account);
		logger.info("Token : {}",token);
		assertNotNull(token);
		
		String token2 = generator.getOrCreat(account);
		logger.info("Token2 : {}",token);
		assertTrue(token.equals(token2) );
	}

}
