package com.demo.user.service;

import com.demo.user.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  User service 
 * </p>
 *
 * @author Larry_lee
 * @since 2020-07-04
 */
public interface IUserService extends IService<User> {
	
	/**
	 * query user By account
	 * @param account
	 * @return
	 */
	User queryUserByAccount(String account);

}
