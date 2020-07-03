package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * news registry center
 * @author Larry_lee
 * @since 2020-07-03
 */
@SpringBootApplication
@EnableEurekaServer
public class RegistryCenterApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(RegistryCenterApplication.class, args);
	}

}
