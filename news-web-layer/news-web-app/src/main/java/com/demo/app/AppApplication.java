package com.demo.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * App web 
 * @author Larry_lee
 * @since
 */
@EnableFeignClients(basePackages = {"com.demo.user","com.demo.news"})
@EnableDiscoveryClient
@SpringBootApplication
public class AppApplication {
	

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}

}
