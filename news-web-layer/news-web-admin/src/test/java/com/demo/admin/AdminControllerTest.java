package com.demo.admin;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.demo.admin.controller.AdminController;
import com.demo.news.entity.NNews;
import com.demo.param.PageResultEntity;
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
		ResponseMessage<PageResultEntity<List<NNews>>> resp = adminController.getNewsList(1,10);
		assertNotNull(resp);
	}
	
	@Test
	public void addNewsTest() {
		NNews news = new NNews();
		news.setNTag("1test");
		news.setNTitle("test1111");
		news.setNContent("this is test content");
		ResponseMessage<String> resp = adminController.addNews(news);
		assertNotNull(resp);
	}
	
	@Test
	public void updateNewsTest() {
		NNews news = new NNews();
		news.setNId(2l);
		news.setNTag("1test");
		news.setNTitle("test1111");
		news.setNContent("this is test content");
		ResponseMessage<String> resp = adminController.updateNews(news);
		assertNotNull(resp);
	}
	
	@Test
	public void getNewsTest() {
		ResponseMessage<NNews> resp = adminController.getNews(2l);
		assertNotNull(resp);
	}
	
	@Test
	public void delNewsTest() {
		ResponseMessage<String> resp = adminController.deleteNews(11L);
		assertNotNull(resp);
	}
	

}
