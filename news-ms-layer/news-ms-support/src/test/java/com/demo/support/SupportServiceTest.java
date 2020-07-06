package com.demo.support;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.demo.user.controller.UserController;
import com.demo.user.entity.User;
import com.demo.web.ResponseMessage;

/**
 * Support service test
 * @author Larry_lee
 * @since 2020-07-04
 */
@SpringBootTest(classes = SupportApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class SupportServiceTest {
	
	Logger logger = LoggerFactory.getLogger(SupportServiceTest.class);
	
	@Autowired
	UserController userController;
	
	@Test
	public void userLoginTest() {
		User user = new User();
		user.setAccount("test");
		user.setPwd("123456");
		ResponseMessage<String> resp = userController.userLogin(user);
		logger.info("resp:{}",resp);
		assertNotNull(resp);
	}
	
	@Test
	public void userLoginWithOutAccountTest() {
		User user = new User();
		user.setPwd("123456");
		ResponseMessage<String> resp = userController.userLogin(user);
		logger.info("resp:{}",resp);
		assertNotNull(resp);
	}
	
	@Test
	public void userLoginWithOutPwdTest() {
		User user = new User();
		user.setAccount("test");
		ResponseMessage<String> resp = userController.userLogin(user);
		logger.info("resp:{}",resp);
		assertNotNull(resp);
	}
	
	@Test
	public void userRegistAccNotExistTest() {
		User user = new User();
		user.setAccount("test111");
		user.setPwd("123456");
		ResponseMessage<String> resp = userController.userRegist(user);
		logger.info("resp:{}",resp);
		assertNotNull(resp);
	}
	
	@Test
	public void userRegistAccExistTest() {
		User user = new User();
		user.setAccount("test");
		user.setPwd("123456");
		ResponseMessage<String> resp = userController.userRegist(user);
		logger.info("resp:{}",resp);
		assertNotNull(resp);
	}

}
