package com.demo.admin;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.demo.admin.controller.AdminController;
import com.demo.web.ResponseMessage;

/**
 * admin controller test
 * @author Larry_lee
 * @since 2020-07-04
 */
@SpringBootTest(classes = AdminApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class AdminControllerTest {
	
	@Autowired
	AdminController adminController;

	@Test
	public void getNewsListTest() {
		ResponseMessage<String> resp = adminController.getNewsList();
		assertNotNull(resp);
	}
	
	@Test
	public void addNewsTest() {
		ResponseMessage<String> resp = adminController.addNews();
		assertNotNull(resp);
	}
	
	@Test
	public void updateNewsTest() {
		ResponseMessage<String> resp = adminController.updateNews();
		assertNotNull(resp);
	}
	
	@Test
	public void getNewsTest() {
		ResponseMessage<String> resp = adminController.getNews(11L);
		assertNotNull(resp);
	}
	
	@Test
	public void delNewsTest() {
		ResponseMessage<String> resp = adminController.deleteNews(11L);
		assertNotNull(resp);
	}
	

}
