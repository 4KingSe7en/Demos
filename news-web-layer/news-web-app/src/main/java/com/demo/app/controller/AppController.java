package com.demo.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.news.entity.News;
import com.demo.news.feign.ContentServiceClient;
import com.demo.param.PageResultEntity;
import com.demo.user.enmu.UserType;
import com.demo.user.entity.User;
import com.demo.user.feign.SupportServiceClient;
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
	SupportServiceClient supportServiceClient;

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

	/**
	 * user login
	 * @return
	 */
	@PostMapping("/user/login")
	public ResponseMessage<String> userLogin(@RequestParam String account,@RequestParam String password) {
		User user = new User();
		user.setAccount(account);
		user.setPwd(password);
		user.setType(UserType.APP);
		return supportServiceClient.userLogin(user);
	}

	/**
	 * user regist
	 * @return
	 */
	@PostMapping("/user/regist")
	public ResponseMessage<String> userRegist(@RequestParam String account,@RequestParam String password) {
		User user = new User();
		user.setAccount(account);
		user.setPwd(password);
		user.setType(UserType.APP);
		return supportServiceClient.userRegist(user);
	}

}
