package com.demo.content;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.demo.news.controller.NewsController;
import com.demo.news.entity.News;
import com.demo.param.PageResultEntity;
import com.demo.web.ResponseMessage;
import org.springframework.cloud.client.discovery.DiscoveryClient;


/**
 * content service test
 * @author Larry_lee
 * @since 2020-07-04
 */
@SpringBootTest(classes = ContentApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class ContentServiceTest {
	
	Logger logger = LoggerFactory.getLogger(ContentServiceTest.class);
	
	@Autowired
	NewsController newsController;
	
	@Autowired
	DiscoveryClient client;
	
	@Test
	public void serviceDiscoveryTest() {
		List<ServiceInstance> instances = client.getInstances("ms-content");
		instances.forEach(inst -> {
			logger.info("services -> {}:{}:{}", inst.getServiceId(), inst.getHost(), inst.getPort());
			System.out.println("services -> " + inst.getServiceId() + ":" + inst.getHost() + ":" + inst.getPort());
		});
	}
	
	/**
	 * news list test
	 */
	@Test
	public void getNewsListTest() {
		ResponseMessage<PageResultEntity<List<News>>> resp = newsController.getNewsList(1, 10);
		assertNotNull(resp);
	}
	
	@Test
	public void addNewsTest() {
		News news = new News();
		news.setTag("111");
		news.setTitle("test");
		news.setContent("this is test");
		ResponseMessage<String> resp = newsController.addNews(news);
		assertNotNull(resp);
		assertTrue(resp.getCode() == 200);
	}
	
	@Test
	public void updateNewsTest() {
		News news = new News();
		news.setUuid(200l);
		news.setTag("111");
		news.setTitle("test");
		news.setContent("this is test");
		ResponseMessage<String> resp = newsController.updateNews(news);
		assertNotNull(resp);
		assertTrue(resp.getCode() == 200);
	}
	
	@Test
	public void deleteNewsTest() {
		ResponseMessage<String> resp = newsController.deleteNews(200L);
		assertNotNull(resp);
	}
	
	@Test
	public void getNewsTest() {
		ResponseMessage<News> resp = newsController.getNews(200L);
		assertNotNull(resp);
	}

}
