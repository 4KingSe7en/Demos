package com.demo.app;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.demo.app.controller.AppController;
import com.demo.web.ResponseMessage;

/**
 * app controller test
 * @author Larry_lee
 * @since 2020-07-04
 */
@SpringBootTest(classes = AppApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class AppControllerTest {
	
	@Autowired
	AppController appController;

	@Test
	public void getNewsListTest() {
		ResponseMessage<String> resp = appController.getNewsList();
		assertNotNull(resp);
	}
	
	@Test
	public void getNewsTest() {
		ResponseMessage<String> resp = appController.getNewsDetail();
		assertNotNull(resp);
	}
	

}
