package com.demo.content;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.DEFINED_PORT;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.demo.news.controller.NewsController;
import com.demo.news.entity.News;
import com.demo.param.PageResultEntity;
import com.demo.web.ResponseMessage;


/**
 * content service test
 * @author Larry_lee
 * @since 2020-07-04
 */
@SpringBootTest(classes = ContentApplication.class,webEnvironment = DEFINED_PORT)
@RunWith(SpringJUnit4ClassRunner.class)
public class ContentServiceTest {
	
	Logger logger = LoggerFactory.getLogger(ContentServiceTest.class);
	
	@Autowired
	NewsController newsController;
	
	@Autowired
	TestRestTemplate restTemplate;
	
	/**
	 * news list test
	 */
	@Test
	public void getNewsListTest() {
		ResponseMessage<PageResultEntity<List<News>>> resp = newsController.getNewsList(1, 10);
		assertNotNull(resp);
		assertNotNull(resp.getResult());
		logger.info("resp:{}",resp);
		
	}
	
	@Test
	public void addNewsTest() {
		News news = new News();
		news.setTag("111");
		news.setTitle("test");
		news.setContent("this is test");
		ResponseMessage<String> resp = newsController.addNews(news);
		logger.info("resp:{}",resp);
		assertNotNull(resp);
		assertTrue(resp.getCode() == 200);
		logger.info("resp:{}",resp);
	}
	
	@Test
	public void updateNewsTest() {
		News news = new News();
		news.setUuid(2l);
		news.setTag("111");
		news.setTitle("test");
		news.setContent("this is test");
		ResponseMessage<String> resp = newsController.updateNews(news);
		logger.info("resp:{}",resp);
		assertNotNull(resp);
		assertTrue(resp.getCode() == 200);
		logger.info("resp:{}",resp);
	}
	
	@Test
	public void deleteNewsTest() {
		ResponseMessage<String> resp = newsController.deleteNews(5L);
		logger.info("resp:{}",resp);
		assertNotNull(resp);
	}
	
	@Test
	public void getNewsTest() {
		ResponseMessage<News> resp = newsController.getNews(4L);
		logger.info("resp:{}",resp);
		assertNotNull(resp);
		
	}
	
	@Test
	public void serviceExceptionHandlerTest() {
		@SuppressWarnings("rawtypes")
		ResponseEntity<Map> entity = restTemplate.exchange("/news", HttpMethod.PATCH, null, Map.class);
		logger.info("resp : {}", entity);
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, entity.getStatusCode());
	}

}
