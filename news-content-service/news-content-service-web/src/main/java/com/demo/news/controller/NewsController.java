package com.demo.news.controller;


import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.demo.news.entity.News;
import com.demo.news.service.INewsService;
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
public class NewsController {
	
	@Autowired
	INewsService newsService;
	
	@Autowired(required = false)
	ElasticsearchTemplate esTemplate;
	/**
	 * get news List
	 * @return
	 */
	@GetMapping("/list")
	public ResponseMessage<PageResultEntity<List<News>>> getNewsList(
            @RequestParam(defaultValue = "1") Integer pageNum, 
            @RequestParam(defaultValue = "10") Integer pageSize){
//		 如果没时间写就先查询库，
//		SearchQuery searchQuery = new NativeSearchQueryBuilder()
//				// .withQuery(matchQuery("title", word ))
//				.withPageable(PageRequest.of(pageNum, pageSize))
//				.withHighlightFields(new HighlightBuilder.Field("title")
//				.preTags("<em>").postTags("</em>"))
//				.build();
//
//		AggregatedPage<News> newsList = esTemplate.queryForPage(searchQuery, News.class);
//		return ResponseMessage.ok(new PageResultEntity<List<News>>((int) newsList.getNumber(), (int) newsList.getSize(), newsList.get().collect(Collectors.toList()),
//				(int) newsList.getTotalElements()));

		Page<News> page = new Page<>(pageNum, pageSize);
		IPage<News> listNews = this.newsService.page(page, new QueryWrapper<News>(new News()));
		return ResponseMessage.ok(new PageResultEntity<List<News>>((int) listNews.getCurrent(), (int) listNews.getSize(), listNews.getRecords(),
				(int) listNews.getTotal()));
	}
	
	
	/**
	 * add news
	 * @return
	 */
	@PostMapping("/add")
	public ResponseMessage<String> addNews(@Validated @RequestBody News news){
		Objects.nonNull(news);
		Objects.nonNull(news.getTitle());
		// add news
		newsService.save(news);
		return ResponseMessage.ok();
		
	}
	
	/**
	 * add news
	 * @return
	 */
	@PostMapping("/save")
	public ResponseMessage<String> updateNews(@Validated @RequestBody News news){
		// update news
		Objects.nonNull(news);
		Objects.nonNull(news.getUuid());
		Objects.nonNull(news.getTitle());
		
		newsService.save(news);
		return ResponseMessage.ok();
	}
	
	/**
	 * delete news by id
	 * @return
	 */
	@DeleteMapping("/{id}")
	public ResponseMessage<String> deleteNews(@PathVariable("id") Long id){
		Objects.nonNull(id);
		newsService.removeById(id);
		return ResponseMessage.ok();
	}
	
	/**
	 * get news by id
	 * @return
	 */
	@GetMapping("/{id}")
	public ResponseMessage<News> getNews(@PathVariable("id") Long id){
		Objects.nonNull(id);
		return ResponseMessage.ok(newsService.getById(id));
	}

}
