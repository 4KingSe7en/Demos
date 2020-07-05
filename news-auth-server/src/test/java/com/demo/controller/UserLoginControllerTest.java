package com.demo.controller;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.demo.SimpleAuthorizationServerApplicaiton;
import com.demo.param.UserParam;
import com.demo.web.ResponseMessage;

@SpringBootTest(classes = SimpleAuthorizationServerApplicaiton.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class UserLoginControllerTest {


	@Autowired
	LoginController userLoginController;

	@Test
	public void loginTest() {
		UserParam user = new UserParam();
		user.setAccount("sph");
		user.setPassword("111");
		ResponseMessage<String> resp = userLoginController.userLogin(user);
		assertFalse(resp != null);
	}
	
	@Test
	public void loginWithoutAccountTest() {
		UserParam user = new UserParam();
		user.setPassword("111");
		try {
			userLoginController.userLogin(user);
		} catch (Exception e) {
			assertNotNull(e);
		}
		
	}
	
	@Test
	public void loginWithoutPasswordTest() {
		UserParam user = new UserParam();
		user.setAccount("sph");
		try {
			userLoginController.userLogin(user);
		} catch (Exception e) {
			assertNotNull(e);
		}
	}
	
	@Test
	public void loginWithoutUserTypeTest() {
		UserParam user = new UserParam();
		user.setAccount("sph");
		user.setPassword("111");
		ResponseMessage<String> resp = userLoginController.userLogin(user);
		assertFalse(resp != null);
	}

}
