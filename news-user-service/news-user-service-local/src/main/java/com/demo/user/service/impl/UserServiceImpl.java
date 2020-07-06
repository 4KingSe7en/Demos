package com.demo.user.service.impl;

import com.demo.user.entity.User;
import com.demo.user.mapper.UserMapper;
import com.demo.user.service.IUserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

/**
 * <p>
 *  user service implements
 * </p>
 *
 * @author Larry_lee
 * @since 2020-07-04
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

	@Override
	public User queryUserByAccount(String account) {
		QueryWrapper<User> query = new QueryWrapper<User>(new User());
		query.eq("n_account", account);
		List<User> users = this.baseMapper.selectList(query);
		if(users != null && !users.isEmpty()) {
			return users.get(0);
		}
		return null;
	}

}
