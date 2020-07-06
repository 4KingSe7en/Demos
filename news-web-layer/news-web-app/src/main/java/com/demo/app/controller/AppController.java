package com.demo.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.news.entity.News;
import com.demo.news.feign.ContentServiceClient;
import com.demo.param.PageResultEntity;
import com.demo.web.ResponseMessage;

/**
 * App controller
 * 
 * @author Larry_lee
 * @since 2020-07-04
 */
@RestController
@RequestMapping("/app")
public class AppController {

	@Autowired
	ContentServiceClient contentServiceClient;

	/**
	 * get news by page
	 * 
	 * @return
	 */
	@GetMapping("/news")
	public ResponseMessage<PageResultEntity<List<News>>> getNewsList(
			@RequestParam(defaultValue = "1") Integer pageNum,
			@RequestParam(defaultValue = "10") Integer pageSize) {

		return contentServiceClient.getNewsList(pageNum, pageSize);
	}

	/**
	 * get new by id
	 * 
	 * @return
	 */
	@GetMapping("/news/{id}")
	public ResponseMessage<News> getNewsDetail(@PathVariable("id") Long id) {

		return contentServiceClient.getNews(id);
	}

}
