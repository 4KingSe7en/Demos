package com.demo.app;

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

import com.demo.app.controller.AppController;
import com.demo.app.controller.AppUserController;
import com.demo.news.entity.News;
import com.demo.news.feign.ContentServiceClient;
import com.demo.param.PageResultEntity;
import com.demo.user.enmu.UserType;
import com.demo.user.entity.User;
import com.demo.user.feign.SupportServiceClient;
import com.demo.web.ResponseMessage;

/**
 * app controller test
 * @author Larry_lee
 * @since 2020-07-04
 */
@SpringBootTest(classes = AppApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class AppControllerTest {
	
	Logger logger = LoggerFactory.getLogger(AppControllerTest.class);
	
	@InjectMocks
	@Autowired
	AppController appController;
	
	@InjectMocks
	AppUserController userController;
	
	@Mock
	SupportServiceClient supportServiceClient;
	
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
		
		ResponseMessage<PageResultEntity<List<News>>> resp = appController.getNewsList(pageNum,pageSize);
		logger.info("{}",resp);
		assertNotNull(resp);
		assertNotNull(resp.getResult());
	}
	
	@Test
	public void getNewsTest() {
		News news = new News();
		news.setUuid(2L);
		news.setTag("1test");
		news.setTitle("test1111");
		news.setContent("this is test content");
		when(contentServiceClient.getNews(2L)).thenReturn(ResponseMessage.ok(news));
		
		ResponseMessage<News> resp = appController.getNewsDetail(2L);
		logger.info("{}",resp);
		assertNotNull(resp);
		assertNotNull(resp.getResult());
	}
	
	@Test
	public void userRegistTest() {
		
		User sysUser = new User();
		sysUser.setAccount("111");
		sysUser.setPwd("123");
		sysUser.setType(UserType.APP);
		when(supportServiceClient.userRegist(sysUser)).thenReturn(ResponseMessage.ok("nice"));
		
		ResponseMessage<String> resp = userController.userRegist(sysUser);
		logger.info("{}",resp);
		assertNotNull(resp);
		assertNotNull(resp.getResult());
	}
	
	
	

}
