package com.demo.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.web.ResponseMessage;

/**
 * App controller
 * @author Larry_lee
 * @since 2020-07-04
 */
@RestController
@RequestMapping("/app")
public class AppController {

	
	/**
	 * get news by page
	 * @return
	 */
	@GetMapping("/news")
	public ResponseMessage<String> getNewsList() {
		
		return ResponseMessage.ok();
	}
	
	
	/**
	 * get new by id
	 * @return
	 */
	@GetMapping("/news/{id}")
	public ResponseMessage<String> getNewsDetail() {

		return ResponseMessage.ok();
	}
	
	
}
