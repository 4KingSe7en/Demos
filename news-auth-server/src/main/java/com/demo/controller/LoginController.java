package com.demo.controller;

import java.util.Date;

import org.apache.commons.lang.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
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
	
	final static String USER_CLAIM = "name";
	
	@Autowired
	Algorithm algorithm;
	
	@Value("${server.jwt.expire:5}")
	int expireTime;
	
	@Autowired
	SupportServiceClient supportServiceClient;

	@PostMapping("/login")
	public ResponseMessage<String> userLogin(@Validated @RequestBody UserParam user){
		
		User sysUser = new User();
		sysUser.setAccount(user.getAccount());
		sysUser.setPwd(user.getPassword());
		sysUser.setType(UserType.valueOf(user.getUserType()));
		
		ResponseMessage<String> resp = supportServiceClient.userLogin(sysUser);
		Date now = new Date();
		if(resp.getCode() == 200) {
			// login success
			String token = JWT.create()
		            .withIssuer("SPH")    
		            .withIssuedAt(now)
		            // defa
		            .withExpiresAt(DateUtils.addSeconds(now, expireTime))
		            .withClaim(USER_CLAIM,user.getAccount()) 
		            .sign(algorithm);
			resp.setResult(token);
		}
		return resp;
	}
}
