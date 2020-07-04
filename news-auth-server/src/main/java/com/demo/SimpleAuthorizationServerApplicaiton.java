package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * realize a simple authorization server
 * <li>login(username/password) support</li>
 * <li>generate jwt token</li>
 * <li>validate jwt token</li>
 * @author Larry_lee
 * @since 2020-07-04
 */
@SpringBootApplication
public class SimpleAuthorizationServerApplicaiton {

	public static void main(String[] args) {
		SpringApplication.run(SimpleAuthorizationServerApplicaiton.class, args);
	}

}
