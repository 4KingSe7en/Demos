package com.demo.admin;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

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

import com.demo.admin.controller.AdminController;
import com.demo.news.entity.News;
import com.demo.news.feign.ContentServiceClient;
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
	
	Logger logger = LoggerFactory.getLogger(AdminControllerTest.class);
	
	@InjectMocks
	@Autowired
	AdminController adminController;
	
	@Mock
	ContentServiceClient contentServiceClient;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void getNewsListTest() {
		int pageNum = 1;
		int pageSize = 10;
		List<News> newsList = new ArrayList<News>();
		News news = new News();
		news.setUuid(1L);
		news.setTitle("test");
		news.setTag("test");
		news.setContent("this is test");
		newsList.add(news);
		
		PageResultEntity<List<News>> pageList = new PageResultEntity<List<News>>(pageNum,pageSize,newsList,1);
		when(contentServiceClient.getNewsList(pageNum, pageSize)).thenReturn(ResponseMessage.ok(pageList));
		ResponseMessage<PageResultEntity<List<News>>> resp = adminController.getNewsList(1,10);
		logger.info("RESP:{}",resp);
		
		assertNotNull(resp);
		assertNotNull(resp.getResult());
	}
	
	@Test
	public void addNewsTest() {
		News news = new News();
		news.setTag("1test");
		news.setTitle("test1111");
		news.setContent("this is test content");
		when(contentServiceClient.addNews(news)).thenReturn(ResponseMessage.ok("nice"));
		ResponseMessage<String> resp = adminController.addNews(news);
		logger.info("RESP:{}",resp);
		
		assertNotNull(resp);
		assertNotNull(resp.getResult());
	}
	
	@Test
	public void updateNewsTest() {
		News news = new News();
		news.setUuid(2l);
		news.setTag("1test");
		news.setTitle("test1111");
		news.setContent("this is test content");
		when(contentServiceClient.updateNews(news)).thenReturn(ResponseMessage.ok("nice"));
		ResponseMessage<String> resp = adminController.updateNews(news);
		logger.info("RESP:{}",resp);
		
		assertNotNull(resp);
		assertNotNull(resp.getResult());
	}
	
	@Test
	public void getNewsTest() {
		News news = new News();
		news.setUuid(2l);
		news.setTag("1test");
		news.setTitle("test1111");
		news.setContent("this is test content");
		when(contentServiceClient.getNews(2l)).thenReturn(ResponseMessage.ok(news));
		ResponseMessage<News> resp = adminController.getNews(2l);
		logger.info("RESP:{}",resp);
		
		assertNotNull(resp);
		assertNotNull(resp.getResult());
	}
	
	@Test
	public void delNewsTest() {
		when(contentServiceClient.deleteNews(11l)).thenReturn(ResponseMessage.ok("nice"));
		ResponseMessage<String> resp = adminController.deleteNews(11L);
		logger.info("RESP:{}",resp);
		
		assertNotNull(resp);
		assertNotNull(resp.getResult());
	}
	
}
