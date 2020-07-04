package com.demo.admin.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.web.ResponseMessage;

/**
 * Admin controller
 * @author Larry_lee
 * @since 2020-07-04
 */
@RestController
@RequestMapping("/admin")
public class AdminController {
	
	/**
	 * get news by page
	 * @return
	 */
	@GetMapping("/news")
	public ResponseMessage<String> getNewsList(){
		
		return ResponseMessage.ok();
	}
	
	
	/**
	 * add news
	 * @return
	 */
	@PatchMapping("/news")
	public ResponseMessage<String> addNews(){
		
		return ResponseMessage.ok();
	}
	
	/**
	 * add news
	 * @return
	 */
	@PutMapping("/news")
	public ResponseMessage<String> updateNews(){
		
		return ResponseMessage.ok();
	}
	
	/**
	 * delete news by id
	 * @return
	 */
	@DeleteMapping("/news/{id}")
	public ResponseMessage<String> deleteNews(@PathVariable("id") Long id){
		
		return ResponseMessage.ok();
	}
	
	/**
	 * get news by id
	 * @return
	 */
	@GetMapping("/news/{id}")
	public ResponseMessage<String> getNews(@PathVariable("id") Long id){
		
		return ResponseMessage.ok();
	}
	

}
