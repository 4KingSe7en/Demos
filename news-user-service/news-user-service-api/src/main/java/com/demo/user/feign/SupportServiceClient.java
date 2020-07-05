package com.demo.user.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.demo.user.entity.NUser;
import com.demo.web.ResponseMessage;

@FeignClient("ms-support")
public interface SupportServiceClient {

	/**
	 * user login
	 * 
	 * @return
	 */
	@PostMapping("/user/login")
	ResponseMessage<String> userLogin(@Validated @RequestBody NUser user);

	/**
	 * user regist
	 * 
	 * @return
	 */
	@PostMapping("/user/regist")
	ResponseMessage<String> userRegist(@Validated @RequestBody NUser user);
}
