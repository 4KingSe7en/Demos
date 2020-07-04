package com.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;

/**
 * user service start config
 * @author Larry_lee
 * @since 2020-07-04
 */
@Configuration
@MapperScan("cn.demo.user.mapper")
@EnableCaching
public class UserServiceConfig {
	

}
