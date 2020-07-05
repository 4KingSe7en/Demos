package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.jwt.JWTTokenGenerator;
import com.demo.param.UserParam;
import com.demo.user.enmu.UserType;
import com.demo.user.entity.User;
import com.demo.user.feign.SupportServiceClient;
import com.demo.web.ResponseMessage;

/**
 * 
 * @author Larry_lee
 *
 */
@RestController
@RequestMapping
public class LoginController {
	
	@Autowired
	JWTTokenGenerator jtGenerator;
	
	@Autowired
	SupportServiceClient supportServiceClient;

	@PostMapping("/login")
	public ResponseMessage<String> userLogin(@Validated @RequestBody UserParam user){
		
		User sysUser = new User();
		sysUser.setAccount(user.getAccount());
		sysUser.setPwd(user.getPassword());
		sysUser.setType(UserType.valueOf(user.getUserType()));
		
		ResponseMessage<String> resp = supportServiceClient.userLogin(sysUser);
		if(resp.getCode() == 200) {
			// login success
			String token = jtGenerator.getOrCreat(user.getAccount());
			resp.setResult(token);
		}
		return resp;
	}
}
