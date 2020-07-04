package com.demo.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.param.UserParam;
import com.demo.web.ResponseMessage;

@RestController
@RequestMapping("/user")
public class UserLoginController {
	
	public ResponseMessage<String> userLogin(@Validated @RequestBody UserParam user){
		
		
		return null;
	}

}
