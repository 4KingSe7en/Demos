package com.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * user service start config
 * @author Larry_lee
 * @since 2020-07-04
 */
@Configuration
@MapperScan("com.demo.user.mapper")
@ComponentScan("com.demo.user")
@EnableCaching
public class UserServiceConfig {
	
}
