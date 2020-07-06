package com.demo.news.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.news.entity.News;
import com.demo.param.PageResultEntity;
import com.demo.web.ResponseMessage;

@FeignClient("ms-content")
public interface ContentServiceClient {

	/**
	 * get news List
	 * 
	 * @return
	 */
	@GetMapping("/news/list")
	ResponseMessage<PageResultEntity<List<News>>> getNewsList(
			@RequestParam(defaultValue = "1") Integer pageNum,
			@RequestParam(defaultValue = "10") Integer pageSize);

	/**
	 * add news
	 * 
	 * @return
	 */
	// TODO:fix patch not support
	@PostMapping("/news/add")
	ResponseMessage<String> addNews(News news);

	/**
	 * add news
	 * 
	 * @return
	 */
	@PostMapping("/news/save")
	ResponseMessage<String> updateNews(News news);

	/**
	 * delete news by id
	 * 
	 * @return
	 */
	@DeleteMapping("/news/{id}")
	ResponseMessage<String> deleteNews(@PathVariable("id") Long id);

	/**
	 * get news by id
	 * 
	 * @return
	 */
	@GetMapping("/news/{id}")
	ResponseMessage<News> getNews(@PathVariable("id") Long id);

}
