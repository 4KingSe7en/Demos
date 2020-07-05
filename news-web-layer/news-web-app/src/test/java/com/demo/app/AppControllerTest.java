package com.demo.app;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.demo.app.controller.AppController;
import com.demo.news.entity.NNews;
import com.demo.param.PageResultEntity;
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
	
	@Autowired
	AppController appController;

	@Test
	public void getNewsListTest() {
		ResponseMessage<PageResultEntity<List<NNews>>> resp = appController.getNewsList(1,10);
		logger.info("{}",resp);
		assertNotNull(resp);
	}
	
	@Test
	public void getNewsTest() {
		ResponseMessage<NNews> resp = appController.getNewsDetail(200L);
		logger.info("{}",resp);
		assertNotNull(resp);
	}
	

}
