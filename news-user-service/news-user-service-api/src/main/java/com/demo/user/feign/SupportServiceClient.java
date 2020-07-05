package com.demo.user.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.demo.user.entity.User;
import com.demo.web.ResponseMessage;

@FeignClient("ms-support")
public interface SupportServiceClient {

	/**
	 * user login
	 * 
	 * @return
	 */
	@RequestMapping(value = "/user/login",method = RequestMethod.POST)
	ResponseMessage<String> userLogin(@Validated @RequestBody User user);

	/**
	 * user regist
	 * 
	 * @return
	 */
	@RequestMapping(value = "/user/regist",method = RequestMethod.POST)
	ResponseMessage<String> userRegist(@Validated @RequestBody User user);
}
