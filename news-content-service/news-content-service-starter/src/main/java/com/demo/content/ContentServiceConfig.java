package com.demo.content;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Content service start config
 * @author Larry_lee
 * @since 2020-07-04
 */
@Configuration
@MapperScan("com.demo.news.mapper")
@ComponentScan("com.demo.news")
@EnableCaching
public class ContentServiceConfig {
	

}
