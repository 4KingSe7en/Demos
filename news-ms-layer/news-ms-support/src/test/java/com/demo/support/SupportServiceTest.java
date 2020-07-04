package com.demo.support;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.demo.user.controller.NUserController;
import com.demo.user.entity.NUser;
import com.demo.web.ResponseMessage;

/**
 * Support service test
 * @author Larry_lee
 * @since 2020-07-04
 */
@SpringBootTest(classes = SupportApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class SupportServiceTest {
	
	@Autowired
	NUserController userController;
	
	@Test
	public void userLoginTest() {
		NUser user = new NUser();
		user.setNAccount("larry");
		user.setNPassword("123456");
		ResponseMessage<String> resp = userController.userLogin(user);
		assertNotNull(resp);
	}
	
	@Test
	public void userRegistTest() {
		NUser user = new NUser();
		user.setNAccount("larry");
		user.setNPassword("123456");
		ResponseMessage<String> resp = userController.userRegist(user);
		assertNotNull(resp);
	}

}
