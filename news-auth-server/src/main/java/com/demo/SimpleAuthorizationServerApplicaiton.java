package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * realize a simple authorization server
 * <li>login(username/password) support</li>
 * <li>generate jwt token</li>
 * @author Larry_lee
 * @since 2020-07-04
 */
@EnableFeignClients(basePackages = {"com.demo.user"})
@EnableDiscoveryClient
@SpringBootApplication
public class SimpleAuthorizationServerApplicaiton {

	public static void main(String[] args) {
		SpringApplication.run(SimpleAuthorizationServerApplicaiton.class, args);
	}

}
