package com.demo.user.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.user.entity.NUser;
import com.demo.user.service.INUserService;
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
public class NUserController {
	
	@Autowired
	INUserService userService;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	/**
	 * user login 
	 * @return
	 */
	public ResponseMessage<String> userLogin(@Validated @RequestBody NUser user ){
		NUser realUser = userService.query()
				.eq("n_account", user.getNAccount())
				.getEntity();
		if(realUser == null) {
			return ResponseMessage.error("account["+user.getNAccount()+"] not exist");
		} else if(passwordEncoder.matches(user.getNPassword(), realUser.getNPassword())){
			return ResponseMessage.ok();
		}
		return ResponseMessage.error("account or password not correct");
		
	}
	
	/**
	 * user regist 
	 * @return
	 */
	public ResponseMessage<String> userRegist(@Validated @RequestBody NUser user){
		int count = userService.query()
				.eq("n_account", user.getNAccount())
				.count();
		// account not exist
		if(count == 0) {
			user.setNPassword(passwordEncoder.encode(user.getNPassword()));
			userService.save(user);
			return ResponseMessage.ok();
		} else {
			// already exist
			return ResponseMessage.error("account["+user.getNAccount()+"] already exist");
		}
		
	}

}
