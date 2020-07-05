package com.demo.content;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * content service base news content module
 * @author Larry_lee
 * @since 2020-07-04
 */
@EnableFeignClients(basePackages = "com.demo.news")
@EnableDiscoveryClient
@SpringBootApplication
public class ContentApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContentApplication.class, args);
	}

}
