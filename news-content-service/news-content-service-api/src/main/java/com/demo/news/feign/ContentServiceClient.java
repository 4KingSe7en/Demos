package com.demo.news.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.news.entity.NNews;
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
	ResponseMessage<PageResultEntity<List<NNews>>> getNewsList(
			@RequestParam(defaultValue = "1") Integer pageNum,
			@RequestParam(defaultValue = "10") Integer pageSize);

	/**
	 * add news
	 * 
	 * @return
	 */
	@PatchMapping("/news")
	ResponseMessage<String> addNews(NNews news);

	/**
	 * add news
	 * 
	 * @return
	 */
	@PutMapping("/news")
	ResponseMessage<String> updateNews(NNews news);

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
	ResponseMessage<NNews> getNews(@PathVariable("id") Long id);

}
