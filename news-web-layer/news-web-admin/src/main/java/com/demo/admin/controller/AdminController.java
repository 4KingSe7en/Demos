package com.demo.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.news.entity.News;
import com.demo.news.feign.ContentServiceClient;
import com.demo.param.PageResultEntity;
import com.demo.web.ResponseMessage;

/**
 * Admin controller
 * @author Larry_lee
 * @since 2020-07-04
 */
@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	ContentServiceClient contentServiceClient;
	
	/**
	 * get news by page
	 * @return
	 */
	@GetMapping("/news")
	public ResponseMessage<PageResultEntity<List<News>>> getNewsList(
			@RequestParam(defaultValue = "1") Integer pageNum, 
            @RequestParam(defaultValue = "10") Integer pageSize){
		
		return contentServiceClient.getNewsList(pageNum, pageSize);
	}
	
	
	/**
	 * add news
	 * @return
	 */
	@PatchMapping("/news")
	public ResponseMessage<String> addNews(@RequestBody News news){
		
		return contentServiceClient.addNews(news);
	}
	
	/**
	 * add news
	 * @return
	 */
	@PutMapping("/news")
	public ResponseMessage<String> updateNews(@RequestBody News news){
		
		return contentServiceClient.updateNews(news);
	}
	
	/**
	 * delete news by id
	 * @return
	 */
	@DeleteMapping("/news/{id}")
	public ResponseMessage<String> deleteNews(@PathVariable("id") Long id){
		
		return contentServiceClient.deleteNews(id);
	}
	
	/**
	 * get news by id
	 * @return
	 */
	@GetMapping("/news/{id}")
	public ResponseMessage<News> getNews(@PathVariable("id") Long id){
		
		return contentServiceClient.getNews(id);
	}
	

}
