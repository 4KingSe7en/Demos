package com.demo.news.controller;


import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.demo.news.entity.NNews;
import com.demo.news.service.INNewsService;
import com.demo.param.PageResultEntity;
import com.demo.web.ResponseMessage;

/**
 * <p>
 *  News Controller
 * </p>
 *
 * @author Larry_lee
 * @since 2020-07-04
 */
@RestController
@RequestMapping("/news")
public class NNewsController {
	
	@Autowired
	INNewsService newsService;
	
	/**
	 * get news List
	 * @return
	 */
	@GetMapping("/list")
	public ResponseMessage<PageResultEntity<List<NNews>>> getNewsList(
            @RequestParam(defaultValue = "1") Integer pageNum, 
            @RequestParam(defaultValue = "10") Integer pageSize){
		Page<NNews> page = new Page<>(pageNum, pageSize);
		IPage<NNews> listNews = this.newsService.page(page, new QueryWrapper<NNews>(new NNews()));
		return ResponseMessage.ok(new PageResultEntity<List<NNews>>((int) listNews.getCurrent(), (int) listNews.getSize(), listNews.getRecords(),
				(int) listNews.getTotal()));
	}
	
	
	/**
	 * add news
	 * @return
	 */
	@PatchMapping
	public ResponseMessage<String> addNews(@Validated @RequestBody NNews news){
		// add news
		NNews realNews = newsService.query()
				.eq("n_id", news.getNId())
				.getEntity();
		if(realNews == null) {
			return ResponseMessage.error(" cann't find news[" + news.getNId() + "]");
		} else {
			newsService.save(news);
			return ResponseMessage.ok();
		}
		
		
	}
	
	/**
	 * add news
	 * @return
	 */
	@PutMapping
	public ResponseMessage<String> updateNews(@Validated @RequestBody NNews news){
		// update news
		Objects.nonNull(news.getNId());
		
		newsService.save(news);
		return ResponseMessage.ok();
	}
	
	/**
	 * delete news by id
	 * @return
	 */
	@DeleteMapping("/{id}")
	public ResponseMessage<String> deleteNews(@PathVariable("id") Long id){
		newsService.removeById(id);
		return ResponseMessage.ok();
	}
	
	/**
	 * get news by id
	 * @return
	 */
	@GetMapping("/{id}")
	public ResponseMessage<NNews> getNews(@PathVariable("id") Long id){
		return ResponseMessage.ok(newsService.getById(id));
	}

}
