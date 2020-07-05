package com.demo.user.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.user.entity.User;
import com.demo.user.service.IUserService;
import com.demo.web.ResponseMessage;

/**
 * <p>
 *  user controller
 * </p>
 *
 * @author Larry_lee
 * @since 2020-07-04
 */
@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	IUserService userService;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	/**
	 * user login 
	 * @return
	 */
	@PostMapping("/login")
	public ResponseMessage<String> userLogin(@Validated @RequestBody User user ){
		User realUser = userService.queryUserByAccount(user.getAccount());
		if(realUser == null) {
			return ResponseMessage.error("account["+user.getAccount()+"] not exist");
		} else if(passwordEncoder.matches(user.getPwd(), realUser.getPwd())){
			return ResponseMessage.ok();
		}
		return ResponseMessage.error("account or password not correct");
		
	}
	
	/**
	 * user regist 
	 * @return
	 */
	@PostMapping("/regist")
	public ResponseMessage<String> userRegist(@Validated @RequestBody User user){
		int count = userService.query()
				.eq("n_account", user.getAccount())
				.count();
		// account not exist
		if(count == 0) {
			user.setPwd(passwordEncoder.encode(user.getPwd()));
			userService.save(user);
			return ResponseMessage.ok();
		} else {
			// already exist
			return ResponseMessage.error("account["+user.getAccount()+"] already exist");
		}
		
	}

}
