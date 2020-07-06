package com.demo.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.user.entity.User;
import com.demo.user.feign.SupportServiceClient;
import com.demo.web.ResponseMessage;

/**
 * User regist
 * @author Larry_lee
 * @since 2020-07-05
 */
@RestController
@RequestMapping("/user")
public class AppUserController {
	
	@Autowired
	SupportServiceClient supportServiceClient;

	/**
	 * user regist
	 * @return
	 */
	@PostMapping("/regist")
	public ResponseMessage<String> userRegist(@Validated @RequestBody User user) {
		return supportServiceClient.userRegist(user);
	}

}
